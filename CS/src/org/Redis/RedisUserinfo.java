package org.Redis;

import org.Struct.Userinfo;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisUserinfo {
    private static final String NO="no";
    private static final String YES="yse";


    public String addUser(Userinfo user){
        Jedis jedis=a.b();
        jedis.set(user.getPhoneID(),user.getUserID()+"|"+user.getPwd());
        System.out.println("11111122222222222");
        a.returnResource(jedis);
        return  YES;
    }
    public String getVerify(Userinfo user){
        Jedis jedis=a.b();
        String phoneID_V=user.getPhoneID()+"|#";
        String verify=jedis.get(phoneID_V);
        a.returnResource(jedis);
        return verify;
    }
    public void addVerify(Userinfo user){
        Jedis jedis=a.b();
        String phoneID_V=user.getPhoneID()+"|#";
        jedis.set(phoneID_V,user.getVerify());
        a.returnResource(jedis);
    }
    public String getPwd(Userinfo login){
        Jedis jedis=a.b();
        String pwd_UserID=jedis.get(login.getPhoneID());
        a.returnResource(jedis);
        return pwd_UserID;
    }

 //添加用户《k，v》->《userID，[userName，clothes，playerID]》
    public String addUserName(Userinfo user){
        Jedis jedis=a.b();
        jedis.zadd(user.getUserID(), 1, user.getUserName());
        jedis.zadd(user.getUserID(), 2,user.getClothes());
        jedis.zadd(user.getUserID(), 3,user.getPlayerID());
        a.returnResource(jedis);
        return YES;
    }
    public List getUserName(Userinfo user){
        Jedis jedis=a.b();
        List userinfo=jedis.lrange(user.getUserID(), 0, -1);
        a.returnResource(jedis);
        return userinfo;
    }
    public String changeClothes(Userinfo user){
        Jedis jedis=a.b();
        String clothes= String.valueOf(jedis.zrange(user.getUserID(),2,2));
        jedis.zrem(user.getUserID(),clothes);
        jedis.zadd(user.getUserID(), 2,user.getClothes());
        return YES;

    }
}
