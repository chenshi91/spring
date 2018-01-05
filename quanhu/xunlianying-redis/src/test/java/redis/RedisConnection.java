/**Created	by	chenshi  at	2017年12月31日 上午11:13:02*/
package redis;

import java.util.ArrayList;

import org.junit.Test;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

/**
 * @description:	RedisConnection.java
 * @packageName:	redis
 * @projectName:	xunlianying-redis
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
public class RedisConnection {
	

	@Test
	public	void	redisTest(){
		/**1,创建连接池*/
		JedisPoolConfig jedisPoolConfig = new	JedisPoolConfig();
		
		/**2,每一个服务器信息*/
		JedisShardInfo jedisShardInfo1 = new	JedisShardInfo("localhost", "6379");
		JedisShardInfo jedisShardInfo2 = new	JedisShardInfo("localhost", "6379");
		
		ArrayList<JedisShardInfo> jedisShardInfoList = new	ArrayList<JedisShardInfo>();
		jedisShardInfoList.add(jedisShardInfo1);
		jedisShardInfoList.add(jedisShardInfo2);
		
		/**3,根据配置,生成连接池*/
		ShardedJedisPool shardedJedisPool = new	ShardedJedisPool(jedisPoolConfig, jedisShardInfoList);
		
		/**4,从连接池获取连接*/
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		String userValue = shardedJedis.get("love");
		System.out.println("user:"+userValue);
		ArrayList<String> stringList = new	ArrayList<>();
		stringList.add("chens");
		stringList.add("zhangyi");
		shardedJedis.set("yryz", stringList.toString());
		
		/**5,归还连接*/
		shardedJedisPool.returnResource(shardedJedis);
	}
}
