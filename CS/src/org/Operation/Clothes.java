package org.Operation;

import org.Redis.a;
import redis.clients.jedis.Jedis;

public class Clothes {
    public String change(String UserID,String clothes){
        Jedis jedis=a.b();
        jedis.ltrim(UserID,0 ,1);
//        jedis.l
        jedis.lpush(UserID,clothes);
        a.returnResource(jedis);
        return "ok";
    }
}
