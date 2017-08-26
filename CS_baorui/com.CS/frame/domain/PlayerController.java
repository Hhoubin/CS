package frame.domain;

import frame.DAO.PlayerDAO;
import frame.DAO.RoomDAO;
import frame.domain.notify.CenterController;
import frame.domain.notify.ReadColor;
import struct.Player;
import struct.Room;

public class PlayerController {
    private PlayerDAO pd;
    private RoomDAO rd;
    Player p = new Player();
    Room r=new Room();

    public PlayerController(){pd=new PlayerDAO();}

    public boolean changecol(String userid, String clothes) throws Exception {
        String playerid=userid+"|#";
        p.setPlayerid(playerid);
        pd.changeclo(p);
        return true;
    }

    public String removeblood(String userid,String roomid, String clothes) throws Exception {

        ReadColor rc = new ReadColor();
        String clo=rc.Read("/home/zbr/图片/1.jpg");//返回play的clothes

        String playerid=userid+"|#";//得到playerid
        p.setPlayerid(playerid);

        if(pd.findplay(p).getType().equals(pd.findplay(rd.findroom(r,p)).getType())){//判断如果类型一致不做处理返回队友
            System.out.println("队友击杀无效");
        }else{
            r.setRoomid(roomid);
            p.setClothes(clo);
            int blood=Integer.parseInt(pd.findplay(rd.findroom(r,p)).getBlood());
            //判断血量数
            if(blood-10==0){
                String[] user =rd.findroom(r,p).getPlayerid().split("//|");
                die(user[0]);
            }else {
                blood-=10;
            }
            p.setBlood(String.valueOf(blood));
            pd.save(p);
        }
        CenterController controller=new CenterController();
        controller.notifyPlayers(r);
        return p.getBlood();
    }


    public void removebullet(String userid) throws Exception {
        String playerid=userid+"|#";//得到playerid
        p.setPlayerid(playerid);

        int but= Integer.parseInt(pd.findplay(p).getBullet());
        but-=1;
        p.setBullet(String.valueOf(but));
        pd.save(p);
    }


    public String die(String userid){

        r.getMchannel().remove(userid);
        CenterController controller=new CenterController();
        controller.notifyPlayers(r);
        return null;
    }


    public String record(String userid){

        return null;
    }
}
