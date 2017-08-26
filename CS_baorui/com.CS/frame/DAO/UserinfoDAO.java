package frame.DAO;

import redis.clients.jedis.Jedis;
import struct.Room;
import struct.Userinfo;
import until.redis.Redis;

public class UserinfoDAO {
//	Jedis jedis;

	public Userinfo finduser(Userinfo u) throws Exception {

	    //根据phoneid从redis得到 userid|password
		String[] uid_pwd = Redis.get(u.getPhoneId()).split("\\|");
        u.setUserId(uid_pwd[0]);
        u.setPassword(uid_pwd[1]);

        //根据userid从redis取得 username|clothes|playerid
        u.setUsername(String.valueOf(Redis.zrange(u.getUserId(),1,1)));
        u.setClothes(String.valueOf(Redis.zrange(u.getUserId(),2,2)));
        u.setPlayerId(String.valueOf(Redis.zrange(u.getUserId(),3,3)));
        u.setRecord(String.valueOf(Redis.zrange(u.getUserId(),4,4)));

        //根据phoneID_V从redis取得Verify
        String phoneID_V = u.getPhoneId() + "|#";
        u.setVerify(Redis.get(phoneID_V));

		return u;
	}



	public boolean save(Userinfo u) throws Exception {
		try {

			Redis.set(u.getPhoneId(), u.getUserId() + "|" + u.getPassword());//注册时记录手机号和密码用户名 存入redis K：phoneid V：userid|Password

			String phoneID_V = u.getPhoneId() + "|#";//注册时记录验证码 存入redis K：phoneid|# V：verify
			Redis.set(phoneID_V, u.getVerify());

			Redis.zadd(u.getUserId(), 1, u.getUsername());//存用户各种信息 存入redis K：用户id V：用户名、衣服、角色、战绩
			Redis.zadd(u.getUserId(), 2, u.getClothes());//衣服
			Redis.zadd(u.getUserId(), 3, u.getPlayerId());//角色
			Redis.zadd(u.getUserId(), 4, u.getRecord());//战绩 append追加

		}catch (Exception e) {
			System.out.println("redis存储失败");
			e.printStackTrace();
			return false;
		}
		return true;
	}


	public boolean changeclo(Userinfo u)throws Exception{
	    try {
            String clothes = String.valueOf(Redis.zrange(u.getUserId(), 2, 2));//先删除用户衣服信息 存入redis K：userid V：
            Redis.zrem(u.getUserId(), clothes);//在
            Redis.zadd(u.getUserId(), 2, u.getClothes());
        }catch (Exception e){
            System.out.println("更改衣服失败");
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
