package org.Operation;

//import org.Redis.RLogin;

import org.Struct.Userinfo;

import java.util.UUID;

public class UserinfoControl {
    private static final String NO = "no";
    private static final String YES = "yse";
    private RedisUserinfo ru;
    Userinfo u = new Userinfo();

    public UserinfoControl(){
        ru=new RedisUserinfo();
    }
    //获取验证码  生成一个随机数   verify（验证码）
    public  String setVerify(int len) {
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
    public  String getVerify(String phoneID) {
        //拿到验证码
        String verify = setVerify(4);
        u.setPhoneID(phoneID);
        u.setVerify(verify);
        ru.addVerify(u);
        return verify;
    }

//注册

    public  String register(String phoneID, String pwd, String verify) {
        u.setPhoneID(phoneID);
        u.setPwd(pwd);
        u.setVerify(verify);
        ru.getVerify(u);
        if (verify.equals(u.getVerify())) {
            String userID = UUID.randomUUID().toString().replaceAll("-", "");
            u.setUserID(userID);
            ru.addUser(u);
            return "注册成功，请完善信息！";
        }
        return "验证码不正确，请重新输入！";
    }


    //登录
    public  String getLogin(String phoneID, String pwd) {
        u.setPhoneID(phoneID);
        ru.getPwd(u);
        String[] pwd_userid = u.getPwd().split("\\|");
        if (pwd.equals(pwd_userid[1]))
            return "登录成功";
        else return "密码不正确";

    }

    //添加用户名
    public  String addName(String phoneID, String userName) {
        u.setPhoneID(phoneID);
        ru.getPwd(u);
        String[] pwd_userid = u.getPwd().split("\\|");
        String playerID = pwd_userid[0] + "|#";    //
        u.setUserID(pwd_userid[0]);
        u.setPlayerID(playerID);
        u.setUserName(userName);
        u.setClothes("blue"); //衣服标识默认时蓝色
        u.setRecord("0");
        ru.addUserName(u);
        //++++++++++++++++++++++++++++++++
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println(u.getUserName()+"的个人信息：");
        System.out.println("userID ："+u.getUserID());
        System.out.println("clothes ："+u.getClothes());
        System.out.println("playerID ："+u.getPlayerID());
        System.out.println("record ："+u.getRecord());
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++");
        return "注册成功";
    }


    //获取用户信息

    public String getUserinfo(String phoneID) {
        u.setPhoneID(phoneID);
        RedisUserinfo ru = new RedisUserinfo();
        ru.getPwd(u);
        String[] pwd_userid =u.getPwd().split("\\|");
        u.setUserID(pwd_userid[0]);
        ru.getUserName(u);
        String userName=u.getUserName()+"|"+u.getUserID()+"|"+u.getClothes()+"|"+u.getPhoneID()+"|"+u.getRecord();
        return userName;
    }

//   改变衣服颜色
    public  String change(String userID, String clothes){
        u.setUserID(userID);
        u.setClothes(clothes);
        return ru.changeClothes(u);
    }



}