package org.AcceptHandle;

import org.Operation.*;

public class Accept {

    private String[] Requst;
    private String result;
    public Accept(String[] a) {
        this.Requst=a;
    }
    public String LoginRequst(){
            if (Requst[0].equals("Longin")) {
                Login login = new Login();
                result =login.getLogin(Requst[1], Requst[2]);//1手机号2密码
                return result;
            }else if(Requst[0].equals("verify")){
                Verify verify =new Verify();
                 result=verify.getVerify(Requst[1]);//手机号
                return result;
            }else if(Requst[0].equals("Register")){
                Register register= new Register();
                //result=结果
                result=register.Have_Not(Requst[1],Requst[2],Requst[3]);//1 手机号 2 密码 3 验证码
                return result;
            } else if (Requst[0].equals("UserName")){
                UserName userName=new UserName();
                result=userName.setName(Requst[1],Requst[2]);//1手机号2UserName
                return result;
            } else if (Requst[0].equals("Userinfo")){
                Userinfo userinfo=new Userinfo();
                result=userinfo.setUserinfo(Requst[1]);//1用户id  UserID
                return result;
            } else if (Requst[0].equals("Clothes")){
                Clothes c=new Clothes();
                result=c.change(Requst[1],Requst[2]);//1UserID ,2 Clothes(颜色)                }
                return result;
            } else if (Requst[0].equals("Clothes")) {
                Clothes c = new Clothes();
                result = c.change(Requst[1], Requst[2]);//1UserID ,2 Clothes(颜色)                }
                return result;
            }else if (Requst[0].equals("Setup")){

            }
            return "aa";

    }
}
