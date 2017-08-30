package org.Operation;

import io.netty.channel.Channel;

import java.util.HashMap;

public class Map1 {
    private static HashMap<Integer, Zoom> zoom_value = new HashMap<Integer, Zoom>();
    
    public static void hashmap(Integer roomid, Zoom zoom) {
        zoom_value.put(roomid, zoom);
    }

    public static Zoom join(Integer roomid, String userid, Channel ctx){
        Zoom zoom=zoom_value.get(roomid);
        zoom.hashmap(userid,ctx);
        return zoom;
    }
    public static Zoom join1(Integer roomid){
        Zoom zoom=zoom_value.get(roomid);
        return zoom;
    }
}
