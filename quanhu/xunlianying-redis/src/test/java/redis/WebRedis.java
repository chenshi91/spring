/**Created	by	chenshi  at	2018年1月1日 上午8:41:03*/
package redis;

import org.junit.Before;
import org.junit.Test;

import com.quanhu.base.test.CommonTest;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @description:	WebRedis.java
 * @packageName:	redis
 * @projectName:	xunlianying-redis
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class WebRedis extends	CommonTest{
	
	@Before
	public	void	before2(){
		createApplicationContext("spring-redis.xml");
	}
	
	@Test
	public	void	redis(){
		ShardedJedisPool	shardedJedisPool=(ShardedJedisPool) ac.getBean("shardedJedisPool");
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		String value = shardedJedis.get("user");
		System.out.println(value);
	}

}
