/**Created	by	chenshi  at	2018年3月11日 下午2:37:24*/
package com.quanhu.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @description:	RedisTempleteTest.java
 * @packageName:	com.quanhu.redis
 * @projectName:	xunlianying-redis
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class RedisTempleteTest {
	ShardedJedisPool jedisPool=null;

	@Before
	public void createApplicationContext(){
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-redis.xml");
		jedisPool = ac.getBean("shardedJedisPool",ShardedJedisPool.class);
	}
	@Test
	public void add(){
		System.out.println("aaaaaaaaa:"+jedisPool);
		ShardedJedis shardedJedis = jedisPool.getResource();
		Jedis shard = jedisPool.getResource().getShard("111");
		Long append = shardedJedis.append("wuhan-guanggu", "xujiali");
	}

}
