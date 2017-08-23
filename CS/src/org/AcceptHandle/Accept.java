package org.AcceptHandle;

import io.netty.channel.Channel;
import org.Handler.Inform;
import org.Operation.Room;
import org.Operation.UserinfoControl;
import org.Operation.Zoom;

public class Accept  {
private Channel ctx;
    private String[] Requst;
    private String result;
    public Accept(String[] a , Channel ctx) {
        this.Requst=a;
        this.ctx=ctx;
    }
    public String loginRequst(){
            if (Requst[0].equals("Longin")) {
                result =UserinfoControl.getLogin(Requst[1], Requst[2]);//1手机号2密码
                return result;
            }
            else if(Requst[0].equals("verify")){
                 result=UserinfoControl.getVerify(Requst[1]);//手机号
                return result;
            }
            else if(Requst[0].equals("Register")){
                result=UserinfoControl.register(Requst[1],Requst[2],Requst[3]);//1 手机号 2 密码 3 验证码
                return result;
            }
            else if (Requst[0].equals("UserName")){
                result=UserinfoControl.addName(Requst[1],Requst[2]);//1手机号2UserName
                return result;
            }
            else if (Requst[0].equals("GetUserinfo")){
                result= String.valueOf(UserinfoControl.getUserinfo(Requst[1]));//1电话号码  phoneID
                return result;
            }
            else if (Requst[0].equals("Clothes")){
//                Clothes c=new Clothes();
                result=UserinfoControl.change(Requst[1],Requst[2]);//1UserID ,2 Clothes(颜色)                }
                return result;
            }
            else if (Requst[0].equals("Setup")){
                Zoom zoom=new Zoom();  //小map
                Channel[] coomChannel=zoom.Creat(Requst[1],zoom ,ctx);       //roomid     ,  zoom

                Inform inform =new Inform();
                inform.writeandflush(coomChannel);
            }
            else if (Requst[0].equals("Addroom")) {
//                ChannelHandler ch = new ChannelHandler();
//                Integer roomid=new Integer(Requst[1]);
//                Channel[] coomChannel=ch.addroom(roomid, ctx);
                Zoom zoom=new Zoom();
                Integer roomID=new Integer(Requst[1]);
                Channel[] coomChannel=zoom.join(roomID,Requst[0],ctx);
                Inform socketID =new Inform();
                socketID.writeandflush(coomChannel);
            }

            return "aa";

    }


}
