/**Created	by	chenshi  at	2018年3月11日 下午2:37:24*/
package com.quanhu.redis;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Client;
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
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring-redis.xml");
		jedisPool = ac.getBean("shardedJedisPool",ShardedJedisPool.class);
	}
	@Test
	public void add(){
		System.out.println("aaaaaaaaa:"+jedisPool);
		ShardedJedis shardedJedis = jedisPool.getResource();
//		Jedis shard = jedisPool.getResource().getShard("jedisShardInfo1");
		Long append = shardedJedis.append("address", "武汉大学珞珈学院1");
		System.out.println(append);
		String string = shardedJedis.get("address");
		System.out.println(string);
	}
	
	@Test
	public void select(){
		ShardedJedis shardedJedis = jedisPool.getResource();
		Client client1 = shardedJedis.getShard("school").getClient();
		Client client2 = shardedJedis.getShard("name").getClient();
		System.out.println(client1.getHost()+","+client1);
		System.out.println(client2.getHost()+","+client2);
	}
	

}
