package org.Redis;

import redis.clients.jedis.Jedis;

public class SetRegister {
    //注册
    public  String Verify(String PhoneID ){
        Jedis jedis=a.b();
        String have ;
        try{
            have=jedis.get(PhoneID);
        }catch (NullPointerException e){
            have=null;
        }
        if (have!=null) {
            a.returnResource(jedis);
            return have;
        }else
            return have;//已注册
    }

    public  String Register(String PhoneID ,String Pwd_UserID ){
        Jedis jedis=a.b();
        jedis.set(PhoneID,Pwd_UserID);
        a.returnResource(jedis);
        return "ok";
    }
    public  String UserID(String UserID ,String UserName,String PlayerID,String Clothes){
        Jedis jedis=a.b();
        jedis.lpush(UserID, UserName);
        jedis.lpush(UserID, PlayerID);
        jedis.lpush(UserID, Clothes);
        a.returnResource(jedis);
        return "ok";
    }
}
