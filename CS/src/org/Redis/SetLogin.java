package org.Redis;

import redis.clients.jedis.Jedis;

public class SetLogin {
    //登录---根据PhoneID取出Pwd|UserID
    public static String setLogin(String PhoneID){
    Jedis jedis=a.b();
    String Pwd_UserID=jedis.get(PhoneID);
    a.returnResource(jedis);
    return Pwd_UserID;
}
}
