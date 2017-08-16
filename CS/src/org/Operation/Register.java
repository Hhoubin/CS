package org.Operation;

import org.Redis.SetRegister;

import java.util.UUID;

public class Register {
    //获取uuid为userid
    public static String getuuid(){
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        return uuid;
    }
    //判断
    public String Have_Not(String PhoneID, String Pwd, String Verify){
        SetRegister setRegister=new SetRegister();
        String phoneID=PhoneID+"|#";
        String ver=setRegister.Verify(phoneID);
        if (Verify.equals(ver)){
            String UserID=getuuid();
            String Pwd_UserID=Pwd+"|"+UserID;
            String ve=setRegister.Register(PhoneID,Pwd_UserID);//ok
            return ve;
        } else
            return "no";//验证码错误
    }
}
