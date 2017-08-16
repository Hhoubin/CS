//import org.GetSet.getset;
//import org.Redis.SetLogin;
//import org.Redis.SetRegister;
//
//import java.util.Scanner;
//import java.util.UUID;
//
//public class work {
////    public static String generate(int len){
////        String str="0123456789";
////        String string1="";
////        for(int i=1;i<=4;i++){
////            String num=String.valueOf(str.charAt((int)Math.floor(Math.random()*str.length())));
////            string1+=num;
////            str=str.replaceAll(num,"");
////        }
////        return string1;
////    }
//    public static String getuuid(){
//        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
//        return uuid;
//    }
//    public static void main(String[] args) {
//        getset getset=new getset();
//        Scanner scanner=new Scanner(System.in);
//        String name=scanner.nextLine();//用户名
//        getset.setUserName(name);
//        Scanner scanner1=new Scanner(System.in);
//        String password=scanner1.nextLine();//密码
//        getset.setPwd_UserID(password);
//
//        String uuid=getuuid();//获取uuid
//         System.out.println(uuid);
////        String yanzheng=generate(4);//获取四位数字
////        System.out.println(yanzheng);
//
////        SetLogin login=new SetLogin();
////        login.Login(yanzheng);
//
//        SetRegister register=new SetRegister();
//        register.Register(yanzheng,password);
//    }
//}
