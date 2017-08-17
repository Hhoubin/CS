package org.Operation;

import org.Redis.SetRegister;
import org.Redis.a;
import redis.clients.jedis.Jedis;

public class UserName {
    public String setName(String PhoneID, String UserName) {
        SetRegister setRegister=new SetRegister();

        Jedis jedis= a.b();
        String Pwd_UserID =jedis.get(PhoneID);//Pwd_UserID
        a.returnResource(jedis);

        String[] a=Pwd_UserID.split("\\|");
        String Userid=a[0];
        String PlayerID=Userid+"|#";
        String Clothes="blue";//衣服标识默认时蓝色
        String ver=setRegister.UserID(Userid,PhoneID,PlayerID,Clothes);
        return ver;
    }
}
