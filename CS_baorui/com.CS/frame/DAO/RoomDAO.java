package frame.DAO;

import com.sun.xml.internal.ws.api.ha.StickyFeature;
import redis.clients.jedis.Jedis;
import struct.Player;
import struct.Room;
import struct.Userinfo;
import until.redis.Redis;

public class RoomDAO {
    Jedis jedis;

    public Player findroom(Room r, Player p) throws Exception{
        String room_clothes=r.getRoomid()+"|"+p.getClothes();
        String[] type_userid = Redis.get(room_clothes).split("\\|");
        p.setType(type_userid[0]);
//        u.setPlayerId(String.valueOf(Redis.zrange(u.getUserId(),3,3)));
        p.setPlayerid(type_userid[1]+"|#");
        return p;
    }

    public boolean save(Room r ,Player p) throws Exception {
        //存入redis 以结构 K：roomid|clothes  V：type|userid
        Redis.set(r.getRoomid()+"|"+ p.getClothes(),p.getType()+"|" + p.getPlayerid());
        return false;
    }
}
