package org.Operation;

import org.Redis.a;
import org.Struct.Player;
import org.Struct.Playerinfo;
import org.Struct.Userinfo;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisUserinfo {
    private static final String NO="no";
    private static final String YES="yse";


    public Userinfo addUser(Userinfo user){
        Jedis jedis= a.b();
        jedis.set(user.getPhoneID(),user.getUserID()+"|"+user.getPwd());
        a.returnResource(jedis);
        return user;
    }
    public Userinfo getVerify(Userinfo user){
        Jedis jedis=a.b();
        String phoneID_V=user.getPhoneID()+"|#";
        String verify=jedis.get(phoneID_V);
        a.returnResource(jedis);
        return user;
    }
    public Userinfo addVerify(Userinfo user){
        String phoneID_V=user.getPhoneID()+"|#";
        Jedis jedis=a.b();
        if (jedis.get(phoneID_V).equals(null)) {
            jedis.set(phoneID_V, user.getVerify());
            a.returnResource(jedis);
            return user;
        }else
            return user;

    }
    public Userinfo getPwd(Userinfo login){
        Jedis jedis=a.b();
        login.setPwd(jedis.get(login.getPhoneID()));
        a.returnResource(jedis);
        return login;
    }

 //添加用户《k，v》->《userID，[userName，clothes，playerID]》
    public Userinfo addUserName(Userinfo user){
        Jedis jedis=a.b();
        jedis.zadd(user.getUserID(), 1, user.getUserName());
        jedis.zadd(user.getUserID(), 2,user.getClothes());
        jedis.zadd(user.getUserID(), 3,user.getPlayerID());
        jedis.zadd(user.getUserID(), 4,user.getRecord());
        a.returnResource(jedis);
        return user;
    }
    //获取个人信息
    public Userinfo getUserName(Userinfo user){
        Jedis jedis=a.b();
        List userinfo=jedis.lrange(user.getUserID(), 0, -1);
        a.returnResource(jedis);
        user.setUserName((String) userinfo.get(0));
        user.setClothes((String) userinfo.get(1));
        user.setPlayerID((String) userinfo.get(2));
        user.setRecord((String) userinfo.get(3));
        return user;
    }
//开始游戏需要创建战备信息，获取用户衣服颜色
    public Playerinfo getUserclothes(Playerinfo pinfo){
        Jedis jedis=a.b();
        pinfo.setClothes(String.valueOf(jedis.lrange(pinfo.getUserID(), 2, 2)));
        a.returnResource(jedis);
        return pinfo;
    }

    //开始游戏创建战备信息 ->roomID|clothes ,type|userID
    public Playerinfo addPlayerInfo(Playerinfo pinfo){
        Jedis jedis=a.b();
        jedis.set(pinfo.getRoomID()+"|"+pinfo.getClothes(),pinfo.getType()+"|"+pinfo.getUserID());
        a.returnResource(jedis);
        return pinfo;
    }

    //开始游戏创建战备信息->player, blood(1) bullet(2) record(3)
    public Player addPlayerInfo2(Player p){
        Jedis jedis=a.b();
        jedis.zadd(p.getPlayerid(),1, String.valueOf(p.getBlood()));
        jedis.zadd(p.getPlayerid(),2, String.valueOf(p.getBullet()));
        jedis.zadd(p.getPlayerid(),3, p.getRecord());
        a.returnResource(jedis);
        return p;
    }
    //改变衣服颜色
    public String changeClothes(Userinfo user){
        Jedis jedis=a.b();
        String clothes= String.valueOf(jedis.zrange(user.getUserID(),2,2));
        jedis.zrem(user.getUserID(),clothes);
        jedis.zadd(user.getUserID(), 2,user.getClothes());
        return YES;
    }


    //开始游戏获取
    public List getUserinfo(Userinfo user){
        Jedis jedis=a.b();
        List clothes=jedis.lrange(user.getUserID(), 1, 1);
        a.returnResource(jedis);
        return clothes;
    }
}
