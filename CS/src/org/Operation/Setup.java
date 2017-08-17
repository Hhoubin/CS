package org.Operation;

import org.Redis.a;
import redis.clients.jedis.Jedis;

public class Setup {
public String roomID(int len){
        String str="0123456789";
        String string1="";
        for(int i=1;i<=4;i++){
            String num=String.valueOf(str.charAt((int)Math.floor(Math.random()*str.length())));
            string1+=num;
            str=str.replaceAll(num,"");
        }
        return string1;
    }
    public void SetupRoom(){
        String Verify=roomID(4);
        Jedis jedis=a.b();


    }
}
