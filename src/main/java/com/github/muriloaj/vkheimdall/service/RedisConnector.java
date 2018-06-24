package com.github.muriloaj.vkheimdall.service;


import redis.clients.jedis.Jedis;

public class RedisConnector {

    private static Jedis jedis;

    public static Jedis useJedis(){
        if (jedis == null || !jedis.isConnected()){
            jedis =  new Jedis("127.0.0.1",6379);
            jedis.connect();
        }
        return jedis;
    }
}
