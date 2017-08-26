package struct;

import io.netty.channel.Channel;
import struct.Room;
import until.MapUntil;

import java.util.HashMap;
import java.util.Map;

public class Zoom {


    private static Map<String, Room> mroom = new HashMap<String, Room>();

    public static void hashmap(String roomid, Room room) {
        mroom.put(roomid, room);
    }

    public static Map<String, Room> getMroom() {
        return mroom;
    }

    public static void setMroom(Map<String, Room> mroom) {
        Zoom.mroom = mroom;
    }


    public boolean join(String roomid,String userid, Channel ctx){

        Room roomname=mroom.get(roomid);
        roomname.hashmap(userid,ctx);
        System.out.println(roomid);
        return true;


    }

}
