package org.Struct;

public class Userinfo {
    private String phoneID;//电话号码
    private String pwd;//密码
    private String verify;//验证码
    private String userName;//游戏名字
    private String userID;//游戏id（包括）
    private String clothes;//衣服颜色
    private String playerID;//战备id（包括血量，子弹，衣服颜色，）


    public Userinfo(){

    }
    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }


    public String getPhoneID() {
        return phoneID;
    }

    public void setPhoneID(String phoneID) {
        this.phoneID = phoneID;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getClothes() {
        return clothes;
    }

    public void setClothes(String clothes) {
        this.clothes = clothes;
    }

    public String toString(){
        return this.userName+"|"+this.clothes+"|"+this.playerID;
    }
}
