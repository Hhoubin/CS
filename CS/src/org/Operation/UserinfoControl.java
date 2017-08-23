package org.Operation;

//import org.Redis.RLogin;

import org.Redis.RedisUserinfo;
import org.Struct.Userinfo;

import java.util.List;
import java.util.UUID;

public class UserinfoControl {
    private static final String NO = "no";
    private static final String YES = "yse";


    //获取验证码  生成一个随机数   verify（验证码）
    public static String setVerify(int len) {
        String str = "0123456789";
        String verify = "";
        for (int i = 1; i <= 4; i++) {
            String num = String.valueOf(str.charAt((int) Math.floor(Math.random() * str.length())));
            verify += num;
            str = str.replaceAll(num, "");
        }
        return verify;
    }

    //传来电话号码，生成对应的验证码，以<k,v>-><电话号码，验证码>存入redis
    public static String getVerify(String phoneID) {
        //拿到验证码
        String verify = setVerify(4);

        Userinfo u = new Userinfo();
        u.setPhoneID(phoneID);
        u.setVerify(verify);

        RedisUserinfo ru = new RedisUserinfo();
        ru.addVerify(u);

        return verify;
    }

//注册

    public static String register(String phoneID, String pwd, String verify) {

        Userinfo u = new Userinfo();
        u.setPhoneID(phoneID);
        u.setPwd(pwd);
        u.setVerify(verify);



        RedisUserinfo ru = new RedisUserinfo();
        if (verify.equals(ru.getVerify(u))) {
            String userID = UUID.randomUUID().toString().replaceAll("-", "");
            u.setUserID(userID);
            return ru.addUser(u);
        }
        return NO;
    }


    //登录
    public static String getLogin(String phoneID, String pwd) {

        Userinfo u = new Userinfo();
        u.setPhoneID(phoneID);

        RedisUserinfo ru = new RedisUserinfo();

        String[] pwd_userid = ru.getPwd(u).split("\\|");
        if (pwd.equals(pwd_userid[1]))
            return YES;
        else return NO;

    }

    //添加用户名
    public static String addName(String phoneID, String userName) {
        Userinfo u = new Userinfo();
        u.setPhoneID(phoneID);
        RedisUserinfo ru = new RedisUserinfo();

        String[] pwd_userid = ru.getPwd(u).split("\\|");
        String playerID = pwd_userid[0] + "|#";    //
        u.setUserID(pwd_userid[0]);
        u.setPlayerID(playerID);
        u.setUserName(userName);
        u.setClothes("blue"); //衣服标识默认时蓝色
        return ru.addUserName(u);
    }


    //获取用户信息

    public static List getUserinfo(String phoneID) {
        Userinfo u = new Userinfo();
        u.setPhoneID(phoneID);
        RedisUserinfo ru = new RedisUserinfo();
        String[] pwd_userid = ru.getPwd(u).split("\\|");
        u.setUserID(pwd_userid[0]);
        return ru.getUserName(u);
    }

//   改变衣服颜色
    public static String change(String userID, String clothes){
        Userinfo u = new Userinfo();
        u.setUserID(userID);
        u.setClothes(clothes);
        RedisUserinfo ru = new RedisUserinfo();
        return ru.changeClothes(u);
    }



}