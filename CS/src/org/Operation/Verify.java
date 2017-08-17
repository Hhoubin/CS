package org.Operation;

import org.Redis.a;
import redis.clients.jedis.Jedis;

public class Verify {
    public  String setVerify(int len){
    String str="0123456789";
    String string1="";
    for(int i=1;i<=4;i++){
        String num=String.valueOf(str.charAt((int)Math.floor(Math.random()*str.length())));
        string1+=num;
        str=str.replaceAll(num,"");
    }
    return string1;
}
    public String getVerify(String PhoneID){
        String Verify=setVerify(4);
        Jedis jedis= a.b();
        String phoneID=PhoneID+"|#";
        jedis.set(phoneID,Verify);
        a.returnResource(jedis);

        return Verify;
    }
}
