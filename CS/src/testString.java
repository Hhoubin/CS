import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

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
        System.out.println("向sets集合中加入元素element001："+jedis.sadd("sets", "element001"));
        System.out.println("向sets集合中加入元素element002："+jedis.sadd("sets", "element002"));
        System.out.println("向sets集合中加入元素element003："+jedis.sadd("sets", "element003"));
        System.out.println("向sets集合中加入元素element004："+jedis.sadd("sets", "element004"));
        System.out.println("查看sets集合中的所有元素:"+jedis.smembers("sets"));
        System.out.println();

        System.out.println("=============删=============");
        System.out.println("集合sets中删除元素element003："+jedis.srem("sets", "element003"));
        System.out.println("查看sets集合中的所有元素:"+jedis.smembers("sets"));
        /*System.out.println("sets集合中任意位置的元素出栈："+jedis.spop("sets"));//注：出栈元素位置居然不定？--无实际意义
        System.out.println("查看sets集合中的所有元素:"+jedis.smembers("sets"));*/
        System.out.println();

        System.out.println("=============改=============");
        System.out.println();

        System.out.println("=============查=============");
        System.out.println("判断element001是否在集合sets中："+jedis.sismember("sets", "element001"));
        System.out.println("循环查询获取sets中的每个元素：");
        Set<String> set = jedis.smembers("sets");
        Iterator<String> it=set.iterator() ;
        while(it.hasNext()){
            Object obj=it.next();
            System.out.println(obj);
        }
        System.out.println();

        System.out.println("=============集合运算=============");
        System.out.println("sets1中添加元素element001："+jedis.sadd("sets1", "element001"));
        System.out.println("sets1中添加元素element002："+jedis.sadd("sets1", "element002"));
        System.out.println("sets1中添加元素element003："+jedis.sadd("sets1", "element003"));
        System.out.println("sets1中添加元素element002："+jedis.sadd("sets2", "element002"));
        System.out.println("sets1中添加元素element003："+jedis.sadd("sets2", "element003"));
        System.out.println("sets1中添加元素element004："+jedis.sadd("sets2", "element004"));
        System.out.println("查看sets1集合中的所有元素:"+jedis.smembers("sets1"));
        System.out.println("查看sets2集合中的所有元素:"+jedis.smembers("sets2"));
        System.out.println("sets1和sets2交集："+jedis.sinter("sets1", "sets2"));
        System.out.println("sets1和sets2并集："+jedis.sunion("sets1", "sets2"));
        System.out.println("sets1和sets2差集："+jedis.sdiff("sets1", "sets2"));//差集：set1中有，set2中没有的元素


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
