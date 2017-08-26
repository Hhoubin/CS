package frame.domain.notify;


import io.netty.buffer.ByteBuf;
import io.netty.channel.Channel;
import struct.Player;
import struct.Room;
import struct.Zoom;

import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;



public class CenterController {
    private ArrayList <String> players;
    public Player player;
    private ReadColor readColor;

    public void detach(Observable observable){}

    public void attach(Observable observable){}

    public void blood(Observable observable){

    }

    public void notifyPlayers(Room r){
        Room room=Zoom.getMroom().get(r.getRoomid());

        for (String key : room.getMchannel().keySet()) {
            String d=String.valueOf(room.getMchannel().keySet());
            Channel channel=room.getMchannel().get(key);
            ByteBuf encoded1=channel.alloc().buffer(d.length());
            encoded1.writeBytes(d.getBytes());
            channel.write(encoded1);
            channel.flush();
            //测试
            System.out.println("key= "+ key + " and value= " + room.getMchannel().get(key));
        }

/*        for(Object player:players){
            if(player.getPlayerid().equals(Playerid)){
                this.detach();  //删除阵亡的角色
            }
            else {
                if(player.getType().equals(type)){
                    Player.displayTeam(name);  //队友显示信息
                }
                else {
                    Player.displayEnemy(name);  //敌人显示信息
                }
            }
        }
*/

    }



}
