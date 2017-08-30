package org.AcceptHandle;

import io.netty.channel.Channel;
import org.Operation.Inform;
import org.Operation.Map1;
import org.Operation.UserinfoControl;
import org.Operation.Zoom;

public class Accept  {
    private Channel ctx;
    private String[] Requst;
    private String result;
    private static UserinfoControl uc=new UserinfoControl();
    public Accept(String[] a , Channel ctx) {
        this.Requst=a;
        this.ctx=ctx;
    }
    public String loginRequst(){
            if (Requst[0].equals("Longin")) {
                result =uc.getLogin(Requst[1], Requst[2]);//1手机号2密码
                return result;
            }
            else if(Requst[0].equals("verify")){
                result=uc.getVerify(Requst[1]);//手机号
                return result;
            }
            else if(Requst[0].equals("Register")){
                result=uc.register(Requst[1],Requst[2],Requst[3]);//1 手机号 2 密码 3 验证码
                return result;
            }
            else if (Requst[0].equals("UserName")){
                result=uc.addName(Requst[1],Requst[2]);//1手机号2UserName
                return result;
            }
            else if (Requst[0].equals("GetUserinfo")){
                result= uc.getUserinfo(Requst[1]);//1电话号码  phoneID
                return result;
            }
            else if (Requst[0].equals("Clothes")){
                result=uc.change(Requst[1],Requst[2]);//1UserID ,2 Clothes(颜色)                }
                return result;
            }
            else if (Requst[0].equals("Setup")){
                Zoom zoom=new Zoom();                          //小map
                result=zoom.Creat(Requst[1],zoom ,ctx);       //userid     ,  zoom对象 ，channe
                return result;
            }
            else if (Requst[0].equals("Addroom")) {
                Map1 map1=new Map1();
                Integer roomID=new Integer(Requst[1]);
                Zoom zoom=map1.join(roomID,Requst[2],ctx);
                Inform inform =new Inform();
                inform.writeandflush(zoom);
                return "aaaaaaa";
            }
            return "aa";
    }
}
