package org.Struct;

import java.util.Observable;

public class Player extends Observable {

    private String Playerid;//
//    private String type;//警匪
//    private String Clothes;//颜色
//    private String Weapen;//武器
//    private String palyername;//游戏名
    private int blood;//血
    private int bullet;//子弹
    private String record;//战绩
//    private Inform controller;

//    public Player(){};


//    public Player(String name, String type, Inform controller){
//        this.Playerid=Playerid;
//        this.type=type;
//        this.controller=controller;
//
//        controller.attach(this);
//    }

    public void setPlayerid(String playerid) {
        Playerid = playerid;
    }

    public String getPlayerid() {
        return Playerid;
    }

//    public String getClothes() {
//        return Clothes;
//    }
//
//    public void setClothes(String clothes) {
//        Clothes = clothes;
//    }
//
//    public String getWeapen() {
//        return Weapen;
//    }
//
//    public void setWeapen(String weapen) {
//        Weapen = weapen;
//    }
//
//    public String getPalyername() {
//        return palyername;
//    }
//
//    public void setPalyername(String palyername) {
//        this.palyername = palyername;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
//
//    public void displayTeam(String name){
//        this.palyername=name;
//    }
//
//    public void displayEnemy(String name){
//        this.palyername=name;
//    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getBullet() {
        return bullet;
    }

    public void setBullet(int bullet) {
        this.bullet = bullet;
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }
}
