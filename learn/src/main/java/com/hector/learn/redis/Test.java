package com.hector.learn.redis;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class Test {
	static JedisPool pool= null;
	public static void main(String[] args) {
		//test1Normal();
		//test1Norma2();
		
		Jedis jedis = pool.getResource();
		jedis.set("foo", "bar");
//		jedis.subscribe(jedisPubSub, channels);
		
//		JedisPoolConfig  config = new JedisPoolConfig();
//		config.setMaxTotal(10);
//		config.setMaxIdle(2);
//		
//		HostAndPort node1 = new HostAndPort("127.0.0.1",6391);
//		HostAndPort node2 = new HostAndPort("127.0.0.1",6392);
//		
//		Set<HostAndPort> nodes = new HashSet<HostAndPort>();
//		nodes.add(node1);
//		nodes.add(node2);
//		
//		JedisCluster jedisCluster = new  JedisCluster(nodes,5000,10,config);
//		for(int i =0;i<10;i++){
//			jedisCluster.set(""+i, ""+i);
//		}
//		//jedisCluster.set("people", "people");
//		//String value = jedisCluster.get("a");
//		
//		//System.out.println(value);
//		jedisCluster.close();
		
		
	}

	static void test1Normal(){
		Jedis jedis = new Jedis("localhost");
		long start = System.currentTimeMillis();
		for(int i = 0;i<10;i++){
			String result = jedis.set("n"+i,"n"+i);
			System.out.println(result);
			
		}
		long end = System.currentTimeMillis();
		System.out.println("Simple set " + ((end-start)/1000.0)+ "seconds") ;
		jedis.disconnect();
		
		
	}
	
	
	static void test1Norma2(){
		Jedis jedis = new Jedis("localhost");
		long start = System.currentTimeMillis();
//		for(int i = 0;i<10;i++){
//			String result = jedis.set("n"+i,"n"+i);
//			System.out.println(result);
//			
//		}
//		long end = System.currentTimeMillis();
//		System.out.println("Simple set " + ((end-start)/1000.0)+ "seconds") ;
		jedis.set("n1", "10");
		jedis.disconnect();
	}
	
	
	static void initRedisPool(){
		pool = new JedisPool(new JedisPoolConfig(), "localhost");
	}
}
