/**Created	by	chenshi  at	2017年12月31日 下午12:33:58*/
package com.quanhu.base.redis;

import java.lang.reflect.Method;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.quanhu.base.annotations.RedisAnnotation;
import com.quanhu.base.aops.ServiceLogAop;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @description:	RedisCash.java
 * @packageName:	com.quanhu.base.redis
 * @projectName:	quanhu-base
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Component
@Aspect
public class RedisCash {
	
	@Resource(name="shardedJedisPool")
	ShardedJedisPool	shardedJedisPool;
	
	protected Logger logger = Logger.getLogger(ServiceLogAop.class);
	
	@Around(value="@annotation(com.quanhu.base.annotations.RedisAnnotation) ")
	public Object	around(ProceedingJoinPoint	pjp) throws Throwable{
		/**1,获取目标对象,方法,入参*/
		Object target = pjp.getTarget();
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		
		/**如果方法上没有缓存标注,则跳过redis*/
		/*if(!method.isAnnotationPresent(RedisAnnotation.class)){
			return	pjp.proceed();
		}*/
		
		String	key=target.toString().substring(target.toString().lastIndexOf(".")+1)+"."+method.getName()+"-";
		/**2,获取redis连接,从连接池拿连接*/
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		
		/**2.1如果缓存里面有数据,则直接拿取缓存结果,不调用业务方法*/
		if(!StringUtils.isEmpty(shardedJedis.get(key))){
			String value = shardedJedis.get(key);
			/**2.1.1获取方法上标注对象*/
			RedisAnnotation redisAnnotation = method.getAnnotation(RedisAnnotation.class);
//			Class returnResult = redisAnnotation.returnResult();
			Class<?> forName = Class.forName("com.quanhu.topic.entity.Topic");
			Object parseObject = JSON.parseObject(value, forName);
			logger.debug("获取缓存redis："+value);
			return	parseObject;
		}
		
		/**2.2如果缓存里面没有数据,则调用业务方法,并以键值对形式存入redis缓存*/
		Object proceed = pjp.proceed();
		shardedJedis.set(key, JSON.toJSONString(proceed));
		logger.debug("添加缓存redis："+JSON.toJSONString(proceed));
		/**3,归还redis连接给连接池*/
		shardedJedisPool.returnResource(shardedJedis);
		return	proceed;
	}
	


}
