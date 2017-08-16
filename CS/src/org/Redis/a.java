package org.Redis;

import redis.clients.jedis.Jedis;

public class a {

    public static Jedis b(){
        //申请连接池jedis资源
        RedisUtil redisUtil=new RedisUtil();
        Jedis jedis=redisUtil.getJedis();
        return jedis;
    }
    public static void returnResource(Jedis jedis){
        RedisUtil redisUtil=new RedisUtil();
        redisUtil.returnResource(jedis);
    }
}
