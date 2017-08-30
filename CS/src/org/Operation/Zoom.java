package org.Operation;

import io.netty.channel.Channel;
import org.Struct.Room;

import java.util.HashMap;

public class Zoom {
    //    private static Map1<Integer,Map1>
    public static HashMap<String, Channel> zoom = new HashMap<String, Channel>();
    static Integer roomid = ID();

    public static Integer ID() {
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

    public static void hashmap(String userid, Channel ctx) {
        zoom.put(userid, ctx);
//        System.out.println(zoom.get(userid));
    }

    public static Room join(String userid, Channel ctx) {
        if (zoom.size() <= 10) {
            Zoom.hashmap(userid,ctx);
            Room room = new Room();
            room.setCtx(zoom.get(userid));
            room.setUserID(String.valueOf(zoom.keySet()));

            return room;
        }
        return null;
    }

    public static String Creat(String userid, Zoom zoom1, Channel ctx) {
        zoom1.hashmap(userid, ctx);
        Map1.hashmap(roomid, zoom1);                 //房间号，小map
//        Room room=new Room();
        Map1.join(roomid,userid,ctx);
//        String roomUesrID=room.getUserID();
        return "yes";
    }
}