package until;


import io.netty.channel.Channel;
import java.util.HashMap;

public class MapUntil {

     private static HashMap<Integer, HashMap<Integer, Channel>> room2player= new HashMap<Integer, HashMap<Integer, Channel>>();


     private static HashMap<Integer, Channel> player2channel=new HashMap<Integer,Channel>();



    public static void maproom(Integer roomid) {
        room2player.put(roomid, player2channel);
    }


     public static void mapplay(Integer playerid,Channel ctx){
        player2channel.put(playerid,ctx);
     }

     public static void mapuser(Integer userid,Channel ctx){
         player2channel.put(userid,ctx);
     }
}
