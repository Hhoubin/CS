package org.Operation;

import java.util.HashMap;
import java.util.Map;

public class Map1 {
    private static Map<Integer, Zoom> zoom_value = new HashMap<Integer, Zoom>();

    public static void hashmap(Integer roomid, Zoom zoom) {
        zoom_value.put(roomid, zoom);
    }

//    public Channel[] join(Integer roomid, Channel ctx){
//        Zoom roomname=zoom_value.get(roomid);
////        roomname.Join(ctx);
////        System.out.println(roomid);
//        return new Channel[0];
//    }
}
