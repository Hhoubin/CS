package org.Operation;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;

public class Zoom {
//    private static Map1<Integer,Map1>
    private static Map<String, Room> zoom = new HashMap<String, Room>();
    Integer roomid=ID();
    public Integer ID() {
        String str = "0123456789";
        String string1 = "";
        for (int i = 1; i <= 4; i++) {
            String num = String.valueOf(str.charAt((int) Math.floor(Math.random() * str.length())));
            string1 += num;
            str = str.replaceAll(num, "");
        }
        Integer roomid = new Integer(string1);
        System.out.println(roomid);
        return roomid;
    }

    public static void hashmap(String userid, Room room) {
//        Map1.hashmap(userid,zoom);
        zoom.put(userid, room);
    }

    public void join(String userid, Channel ctx){
//        Room roomname=zoom.get(userid);
//        roomname.Join(ctx);
//        System.out.println(userid);
//        return new Channel[0];
        Room roomname=zoom.get(userid);
        roomname.Join(ctx);
        System.out.println(userid);
    }
    public Channel[] Creat(String userid,Zoom zoom,Channel ctx) {

        Room room=new Room(userid);
        Channel[] coomChannel=room.Creat(room,ctx);// id , room    数组，channel
        Map1.hashmap(roomid,zoom);                 //房间号，小map
        System.out.println(coomChannel);
        return coomChannel;
    }
}
