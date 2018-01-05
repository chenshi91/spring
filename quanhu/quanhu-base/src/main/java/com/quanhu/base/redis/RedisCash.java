/**Created	by	chenshi  at	2017年12月31日 下午12:33:58*/
package com.quanhu.base.redis;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.quanhu.base.App;
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
	
	@Around(value="execution(* com.quanhu..*.service.impl..*.*(..)) or execution(* com.quanhu.base.service.impl..*.*(..))")
	public Object	around(ProceedingJoinPoint	pjp) throws Throwable{
		/**1,获取目标对象,方法,入参*/
		Object target = pjp.getTarget();
		MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
		Method method = methodSignature.getMethod();
		
		String	key=target.toString().substring(target.toString().lastIndexOf(".")+1)+"."+method.getName()+"-";
		/**2,获取redis连接,从连接池拿连接*/
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		
		/**2.1如果缓存里面有数据,则直接拿取缓存结果,不调用业务方法*/
		if(!StringUtils.isEmpty(shardedJedis.get(key))){
			String value = shardedJedis.get(key);
			//List<Topic> list = JSON.parseArray(value, Topic.class);
			//return	list;
		}
		
		/**2.2如果缓存里面没有数据,则调用业务方法,并以键值对形式存入redis缓存*/
		logger.info("--------service----start:"+target.getClass()+"."+method.getName());
		Date startDate = new	Date();
		Object proceed = pjp.proceed();
		logger.info("--------service----end:"+target.getClass()+"."+method.getName()+",耗时毫秒数:"+(new Date().getTime()-startDate.getTime()));
		shardedJedis.set(key, JSON.toJSONString(proceed));
		
		/**3,归还redis连接给连接池*/
		shardedJedisPool.returnResource(shardedJedis);
		return	proceed;
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		ArrayList<App> arrayList = new	ArrayList<>();
		arrayList.add(new App("chens"));
		arrayList.add(new App("zhengm"));
		
		String jsonString = JSON.toJSONString(arrayList);
		System.out.println(jsonString);
		List<App> parseArray = JSON.parseArray(jsonString,App.class);
		for (App app : parseArray) {
			System.out.println(app.toString());
		}
		App app = new	App("tset");
		System.out.println(app.getClass());
		System.out.println(App.class);
		Class<?> forName = Class.forName("com.quanhu.base.App");
		System.out.println(forName.getClass());
	}

}
