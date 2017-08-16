package org.Operation;

//import org.Redis.RLogin;
import org.Redis.SetLogin;

public class Login {
    public String getLogin(String PhoneID, String Pwd){
        SetLogin setLogin=new SetLogin();
        String p= setLogin.setLogin(PhoneID);
        String[] pwd_userid=p.split("\\|");
        if (Pwd.equals(pwd_userid[0]))
        return "ok";
        else{
            return "no";
        }
    }
}
