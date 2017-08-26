package frame.domain;

import frame.DAO.PlayerDAO;
import frame.DAO.RoomDAO;
import io.netty.channel.Channel;
import struct.Player;
import struct.Room;
import struct.Zoom;


public class RoomContoler {

    private PlayerDAO pd;
    private RoomDAO rd;
    Room room=new Room();
    Zoom zoom=new Zoom();
    Player p=new Player();


    public RoomContoler() {
        rd=new RoomDAO();
    }


    public String ID() {
        String str = "0123456789";
        String string1 = "";
        for (int i = 1; i <= 4; i++) {
            String num = String.valueOf(str.charAt((int) Math.floor(Math.random() * str.length())));
            string1 += num;
            str = str.replaceAll(num, "");
        }
        String roomid = new String(string1);
        System.out.println(roomid);

        return roomid;
    }

    //创建房间
    public String Creat(String userid,String Clothes,Channel ctx) throws Exception {
        room.setRoomid(ID());
        zoom.join(room.getRoomid(),userid,ctx);
        String playerid=userid+"|#";//赋值playerid
        p.setPlayerid(playerid);
        p.setType("0"+"|"+"police");//赋值type
        p.setBlood("100");//赋值血量
        p.setClothes(Clothes);//赋值衣服
        p.setBullet("1000000000");
        pd.save(p);//存入redis p对象
        rd.save(room,p);//存入reids RoomDAO:  K:roomid|clothes  V:type|Playerid
        return room.getRoomid();
    }



    public Channel Join(String roomid,String Clothes,String userid,Channel ctx) throws Exception {
        for(int i=1;i<10;) {
            if (zoom.join(roomid, userid, ctx)) {
                i++;
                String playerid=userid+"|#";//赋值playerid
                p.setPlayerid(playerid);
                //设置警匪类型
                if(i%2==0)
                    p.setType("0"+"|"+"police");
                else
                    p.setType("1"+"|"+"bandit");
                p.setBlood("100");//赋值血量
                p.setClothes(Clothes);//赋值衣服
                p.setBullet("100000000");
                pd.save(p);//存入redis p对象
                rd.save(room,p);//存入reids RoomDAO:  K:roomid|clothes  V:type|Playerid

                //测试
                System.out.println("加入房间成功");
            } else {
                System.out.println("加入房间失败");
            }
        }
        return ctx;
    }


}

