/**Created	by	chenshi  at	2018年2月18日 下午7:47:24*/
package com.quanhu.redis;

import org.junit.Test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @description:	RedisDemo.java
 * @packageName:	com.quanhu.redis
 * @projectName:	xunlianying-redis
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class RedisDemo {
	
	/**
	 * 单实例的连接
	 * @description:demo1
	 * @return void
	 */
	@Test
	public void demo1(){
		//1,设置IP地址和端口号
		Jedis jedis = new Jedis("192.168.43.250", 6379);
		//2，保存数据
		jedis.set("school","武汉大学珞珈学院");
		//3，获取数据
		String value = jedis.get("school");
		System.out.println(value);
		//4，释放资源
		jedis.close();
	}
	
	/**
	 * 连接池方式
	 * @description:demo2
	 * @return void
	 */
	@Test
	public void demo2(){
		//获得连接池的配置对象
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		jedisPoolConfig.setMaxTotal(30);
		jedisPoolConfig.setMaxIdle(10);
		
		//获取连接池
		JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost",6379);
		
		//获得核心对象
		Jedis jedis=null;
		try {
			jedis=jedisPool.getResource();
			jedis.set("home", "京山");
			String value = jedis.get("home");
			System.out.println(value);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(jedis!=null){
				jedis=null;
			}
			if(jedisPool!=null){
				jedisPool=null;
			}
		}
	}
}
