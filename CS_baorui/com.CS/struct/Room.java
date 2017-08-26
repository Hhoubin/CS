package struct;

import io.netty.channel.Channel;

import java.util.HashMap;


public class Room {

    private String roomid;//用户id
    Channel channel;//用户管道


    private static HashMap<String, Channel> mchannel=new HashMap<String, Channel>();

    public static void hashmap(String userid, Channel ctx){
        mchannel.put(userid,ctx);
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }

    public static HashMap<String, Channel> getMchannel() {
        return mchannel;
    }

    public static void setMchannel(HashMap<String, Channel> mchannel) {
        Room.mchannel = mchannel;
    }



}

