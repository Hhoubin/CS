package org.Operation;

import org.Struct.Player;
import org.Struct.Playerinfo;

public class Begin {
    private static int BLOOB=60;
    private static int BULLET=10;
    private static String RECORD="0";
    private int i=1;
    private String queue;
    public String player(Integer roomID) {//传来房间号
        Zoom zoomUser = Map1.join1(roomID);
        RedisUserinfo ru = new RedisUserinfo();


        //迭代存战备信息
        for (String userID : zoomUser.zoom.keySet()) {
            Playerinfo pinfo = new Playerinfo();
            ru.getUserclothes(pinfo);
            pinfo.getClothes();
            if (i<=5){
                queue="0|police";//警察->0|police    匪徒 —>1|bandit
                pinfo.setRoomID(roomID);
                pinfo.setType(queue);
                pinfo.setClothes(pinfo.getClothes());
                pinfo.setUserID(userID);
                ru.addPlayerInfo(pinfo);
                i++;
            }else {
                queue="1|bandit";
                pinfo.setRoomID(roomID);
                pinfo.setType(queue);
                pinfo.setClothes(pinfo.getClothes());
                pinfo.setUserID(userID);
                ru.addPlayerInfo(pinfo);
                i++;
            }
        }
        for (String userID : zoomUser.zoom.keySet()) {
            Player player=new Player();
            player.setPlayerid(userID+"|#");
            player.setBlood(BLOOB);
            player.setBullet(BULLET);
            player.setRecord(RECORD);
            ru.addPlayerInfo2(player);
        }
        return "开始游戏";
    }
}