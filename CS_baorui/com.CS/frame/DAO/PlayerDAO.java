package frame.DAO;

import redis.clients.jedis.Jedis;
import struct.Player;
import struct.Userinfo;
import until.redis.Redis;

public class PlayerDAO {
    Jedis jedis;

    public Player findplay(Player p) throws Exception {

        //根据playerid从redis取得 |type|clothes|blood|bullet|record
        p.setType(String.valueOf(Redis.zrange(p.getPlayerid(),1,1)));
        p.setClothes(String.valueOf(Redis.zrange(p.getPlayerid(),2,2)));
        p.setBlood(String.valueOf(Redis.zrange(p.getPlayerid(),3,3)));
        p.setBullet(String.valueOf(Redis.zrange(p.getPlayerid(),4,4)));
        p.setRecord(String.valueOf(Redis.zrange(p.getPlayerid(),5,5)));

        return p;
    }



    public boolean save(Player p) throws Exception {

        //存入 |type|clothes|blood|bullet|record
        Redis.zadd(p.getPlayerid(), 1, p.getType());//警匪类型
        Redis.zadd(p.getPlayerid(), 2, p.getClothes());//衣服
        Redis.zadd(p.getPlayerid(), 3, p.getBlood());//血量
        Redis.zadd(p.getPlayerid(), 4, p.getBullet());//子弹数
        Redis.zadd(p.getPlayerid(), 5, p.getRecord());//战绩 append追加
        return true;
    }

    public boolean changeclo(Player p)throws Exception{
        try {
            String clothes = String.valueOf(Redis.zrange(p.getPlayerid(), 3, 3));//先删除玩家血量信息 存入redis K：userid V：
            Redis.zrem(p.getPlayerid(), clothes);//在
            Redis.zadd(p.getPlayerid(), 2, p.getClothes());
        }catch (Exception e){
            System.out.println("更改衣服失败");
            e.printStackTrace();
            return false;
        }
        return true;
    }


    public boolean changeblo(Player p)throws Exception{
        try {
            String blood = String.valueOf(Redis.zrange(p.getPlayerid(), 3, 3));//先删除玩家血量信息 存入redis K：userid V：
            Redis.zrem(p.getPlayerid(), blood);//在
            Redis.zadd(p.getPlayerid(), 2, p.getBlood());
        }catch (Exception e){
            System.out.println("减血失败");
            e.printStackTrace();
            return false;
        }
        return true;
    }


}

