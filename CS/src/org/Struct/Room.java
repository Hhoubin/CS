package org.Struct;

import io.netty.channel.Channel;

public class Room {
    private String userID;
    private Channel ctx;
//    private Integer roomID;

//    public Integer getRoomID() {
//        return roomID;
//    }
//
//    public void setRoomID(Integer roomID) {
//        this.roomID = roomID;
//    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Channel getCtx() {
        return ctx;
    }

    public void setCtx(Channel ctx) {
        this.ctx = ctx;
    }
}