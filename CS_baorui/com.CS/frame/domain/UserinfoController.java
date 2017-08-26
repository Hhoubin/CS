package frame.domain;

import java.util.UUID;

import frame.DAO.UserinfoDAO;
import redis.clients.jedis.ShardedJedis;
import struct.Userinfo;

public class UserinfoController {
	private ShardedJedis shardedJedis;

//    private static final long serialVersionUID = 1L;
    private UserinfoDAO ud;

    Userinfo u = new Userinfo();

    public UserinfoController() {
        ud=new UserinfoDAO();
    }

	public String Verify(int len) {
		String str = "0123456789";
		String verify = "";
		for (int i = 1; i <= 4; i++) {
			String num = String.valueOf(str.charAt((int) Math.floor(Math.random() * str.length())));
			verify += num;
			str = str.replaceAll(num, "");
		}
		return verify;
	}

	public boolean regist(String PhoneId, String pwd, String verify) {
		try {
			u.setPhoneId(PhoneId);
			u.setPassword(pwd);
			u.setVerify(verify);

//			u = ud.finduser(u);
			if (shardedJedis.exists(u.getPhoneId())) {
				if (ud.save(u)) {
					if (verify.equals(u.getVerify())) {
						String userid = UUID.randomUUID().toString().replaceAll("-", "");
						u.setUserId(userid);
                        String Playerid = userid + "|#";//设置Playerid=userid|#
                        u.setPlayerId(Playerid);//设置玩家id
                        u.setClothes("blue");//默认衣服
						u.setRecord("0");
						ud.save(u);
						return true;
					}else {
						System.out.println("验证码错误");
						return false;
					}
				}else {
					System.out.println("注册失败");
					return false;
				}
			}else{
				System.out.println("此手机号已注册");
				return false;
			}

		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return true;
	}


	public boolean login(String PhoneId, String pwd ) {
        u.setPhoneId(PhoneId);
        u.setPassword(pwd);

		try {
			ud.finduser(u);
            if (u.getPassword().equals(pwd)) {
                return true;
			} else {
                System.out.println("密码错误");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
        return true;
    }


	public void logout()  {

	}


    //   改变衣服颜色
    public boolean Change(String UserId, String clothes){
        u.setUserId(UserId);
        u.setClothes(clothes);
        try {
            ud.changeclo(u);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public Userinfo Getuserinfo(String userid) throws Exception {
        u.setUserId(userid);
        ud.finduser(u);
        return u;
    }


    public boolean Cname(String userid){


		u.setUserId(userid);
		String Playerid = userid + "|#";//设置Playerid=userid|#
		u.setPlayerId(Playerid);//设置玩家id
		u.setClothes("blue");//默认衣服
		u.setRecord("0");
//		ud.save(u);
		return false;
	}
}
