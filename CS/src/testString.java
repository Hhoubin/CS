package org;
import redis.clients.jedis.Jedis;
public class testString  {
    private Jedis jedis;
    private String value = null;

    public testString(Jedis a) {
        this.jedis=a;
    }

    public String getValue(String key) {
        value = jedis.get(key);
        return value;
    }

    public String test() {
        jedis.set("name1","xinxin");//向key-->name中放入了value-->xinxin
        System.out.println(jedis.get("name1"));//执行结果：xinxin


//        jedis.append("name", " is my lover"); //拼接
//        System.out.println(jedis.get("name"));
//
//        jedis.del("name");  //删除某个键
//        System.out.println(jedis.get("name"));
//        //设置多个键值对
//        jedis.mset("name","liuling","age","23","qq","476777XXX");
//        jedis.incr("age"); //进行加1操作
//        System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
        return jedis.get("name1");
    }
}
