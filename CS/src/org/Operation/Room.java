package org.Operation;
import io.netty.channel.Channel;


public class Room {

    Channel[] channel = new Channel[3];
    String userid;
    public Room(String userid){
        this.userid=userid;
    }


    public Channel[] Creat(Room room,Channel ctx) {
        Channel[] channel=room.Join(ctx);
        Zoom.hashmap(userid,room);
        return channel;
    }


    public Channel[] Join(Channel ctx){
        int a = 0;
        for (int i = 0; i < 3; i++) {
            if (channel[i] != null)
                a++;
                System.out.println(channel[i]);
            }
            if (a==2){
            return null;
        }else {
                channel[a] = ctx;
                return channel;
            }
    }
}

