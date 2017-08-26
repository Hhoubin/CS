package Handle;

import frame.domain.UserinfoController;
import struct.Zoom;
import io.netty.channel.Channel;
import until.Test.Inform;


public class Accept  {
    private Channel ctx;
    private String[] Requst;
    private String result;
    public Accept(String[] a , Channel ctx) {
        this.Requst=a;
        this.ctx=ctx;
    }
    public String loginRequst() throws Exception {
        UserinfoController uc=new UserinfoController();
        if (Requst[0].equals("verify")){
            result=uc.Verify(Integer.parseInt(Requst[1]));//手机号
            return result;
        }
        else if(Requst[0].equals("Register")){
            result= String.valueOf(uc.regist(Requst[1],Requst[2],Requst[3]));//1 手机号 2 密码 3 验证码
            return result;
        }
        else if(Requst[0].equals("Login")) {
                result = String.valueOf(uc.login(Requst[1], Requst[2]));//1手机号2密码
                return result;
        }


        else if (Requst[0].equals("GetUserinfo")){
            result= String.valueOf(uc.Getuserinfo(Requst[1]));// 根据userid 取出用户信息 放到rusult[]里
            return result;
        }
        else if (Requst[0].equals("Clothes")){
//                Clothes c=new Clothes();
            result= String.valueOf(uc.Change(Requst[1],Requst[2]));//1UserID ,2 Clothes(颜色)                }
            return result;
        }
        else if (Requst[0].equals("Setup")){
            Zoom zoom=new Zoom();  //小map
//            Channel[] coomChannel=zoom.Creat(Requst[1],zoom ,ctx);       //roomid     ,  zoom

            Inform inform =new Inform();
//            inform.writeandflush(coomChannel);
        }
        else if (Requst[0].equals("Addroom")) {
//                ChannelHandler ch = new ChannelHandler();
//                Integer roomid=new Integer(Requst[1]);
//                Channel[] coomChannel=ch.addroom(roomid, ctx);
            Zoom zoom=new Zoom();
            Integer roomID=new Integer(Requst[1]);
//            Channel[] coomChannel=zoom.join(roomID,Requst[0],ctx);
            Inform socketID =new Inform();
//            socketID.writeandflush(coomChannel);
        }

        return "aa";

    }


}
