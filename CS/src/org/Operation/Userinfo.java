package org.Operation;

import org.Redis.a;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Userinfo {
    public String setUserinfo(String UserID){
        Jedis jedis= a.b();
        List<String> Pwd_UserID =jedis.lrange(UserID, 0, -1);;//list-->k(String UserID) ,v(String UserName,String Clothes,String PlayerID)
        String userinfo=Pwd_UserID.get(0)+"|"+Pwd_UserID.get(1)+"|"+Pwd_UserID.get(2);
        a.returnResource(jedis);
        return userinfo;
    }
}
