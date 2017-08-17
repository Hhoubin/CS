package org.Operation;

import org.Redis.a;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Userinfo {
    public String setUserinfo(String UserID){
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        Jedis jedis= a.b();
        List<String> userinfo =jedis.lrange(UserID, 0, -1);
        //list-->k(String UserID) ,v(String UserName,String PlayerID,String Clothes)
        String userinfo1=userinfo.get(0)+"|"+userinfo.get(1)+"|"+userinfo.get(2);

        a.returnResource(jedis);
        return userinfo1;
    }
}
