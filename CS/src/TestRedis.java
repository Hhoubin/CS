import org.Redis.RedisUtil;
import redis.clients.jedis.Jedis;

public class TestRedis {
        private static Jedis jedis;

        public static void setup() {
            //连接redis服务器，192.168.0.100:6379
            jedis = new Jedis("127.0.0.1", 6379);
            //权限认证
//            jedis.auth("admin");
        }

        /**
         * redis存储字符串
         */
        public static void main(String[] args) {
            TestRedis.setup();
            TestRedis.testString();
            System.out.println("ok!");
        }
        public static void testString() {
            //-----添加数据----------
//            jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin
//            System.out.println(jedis.get("name"));//执行结果：xinxin
//            System.out.println(jedis);
//            System.out.println("01："+jedis.sadd("sets", "001"));
//            System.out.println("02："+jedis.sadd("sets", "002"));
//            System.out.println("03："+jedis.sadd("sets", "003"));
//            System.out.println("04："+jedis.sadd("sets", "004"));
            System.out.println("查看sets集合中的所有元素:"+jedis.smembers("sets"));
//            System.out.println();
//
//            System.out.println("=============删=============");
//            System.out.println("集合sets中删除元素element003："+jedis.srem("sets", "" +
//                    "003"));
//            System.out.println("查看sets集合中的所有元素:"+jedis.smembers("sets"));
//        /*System.out.println("sets集合中任意位置的元素出栈："+jedis.spop("sets"));//注：出栈元素位置居然不定？--无实际意义
//        System.out.println("查看sets集合中的所有元素:"+jedis.smembers("sets"));*/
//            System.out.println();
//
//            System.out.println("=============改=============");
//            System.out.println();
//
//            System.out.println("=============查=============");
//            System.out.println("判断element001是否在集合sets中："+jedis.sismember("sets", "element001"));
//            System.out.println("循环查询获取sets中的每个元素：");
//            Set<String> set = jedis.smembers("sets");
//            Iterator<String> it=set.iterator() ;
//            while(it.hasNext()){
//                Object obj=it.next();
//                System.out.println(obj);
//            }
//            System.out.println();
//
//            System.out.println("=============集合运算=============");
//            System.out.println("sets1中添加元素element001："+jedis.sadd("sets1", "element001"));
//            System.out.println("sets1中添加元素element002："+jedis.sadd("sets1", "element002"));
//            System.out.println("sets1中添加元素element003："+jedis.sadd("sets1", "element003"));
//            System.out.println("sets1中添加元素element002："+jedis.sadd("sets2", "element002"));
//            System.out.println("sets1中添加元素element003："+jedis.sadd("sets2", "element003"));
//            System.out.println("sets1中添加元素element004："+jedis.sadd("sets2", "element004"));
//            System.out.println("查看sets1集合中的所有元素:"+jedis.smembers("sets1"));
//            System.out.println("查看sets2集合中的所有元素:"+jedis.smembers("sets2"));
//            System.out.println("sets1和sets2交集："+jedis.sinter("sets1", "sets2"));
//            System.out.println("sets1和sets2并集："+jedis.sunion("sets1", "sets2"));
//            System.out.println("sets1和sets2差集："+jedis.sdiff("sets1", "sets2"));//差集：set1中有，set2中没有的元素

//            jedis.append("name", " is my lover"); //拼接
//            System.out.println(jedis.get("name"));
//
//            jedis.del("name");  //删除某个键
//            System.out.println(jedis.get("name"));
//            //设置多个键值对
//            jedis.mset("name","liuling","age","23","qq","476777XXX");
//            jedis.incr("age"); //进行加1操作
//            System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));

        }

        /**
         * redis操作Map
         */

//        public void testMap() {
//            //-----添加数据----------
//            Map<String, String> map = new HashMap<String, String>();
//            map.put("name", "xinxin");
//            map.put("age", "22");
//            map.put("qq", "123456");
//            jedis.hmset("user",map);
//            //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List
//            //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数
//            List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
//            System.out.println(rsmap);
//
//            //删除map中的某个键值
//            jedis.hdel("user","age");
//            System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null
//            System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2
//            System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true
//            System.out.println(jedis.hkeys("user"));//返回map对象中的所有key
//            System.out.println(jedis.hvals("user"));//返回map对象中的所有value
//
//            Iterator<String> iter=jedis.hkeys("user").iterator();
//            while (iter.hasNext()){
//                String key = iter.next();
//                System.out.println(key+":"+jedis.hmget("user",key));
//            }
//        }

        /**
         * jedis操作List
         */
//        public void testList(){
//            //开始前，先移除所有的内容
//            jedis.del("java framework");
//            System.out.println(jedis.lrange("java framework",0,-1));
//            //先向key java framework中存放三条数据
//            jedis.lpush("java framework","spring");
//            jedis.lpush("java framework","struts");
//            jedis.lpush("java framework","hibernate");
//            //再取出所有数据jedis.lrange是按范围取出，
//            // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有
//            System.out.println(jedis.lrange("java framework",0,-1));
//
//            jedis.del("java framework");
//            jedis.rpush("java framework","spring");
//            jedis.rpush("java framework","struts");
//            jedis.rpush("java framework","hibernate");
//            System.out.println(jedis.lrange("java framework",0,-1));
//        }

        /**
         * jedis操作Set
         */

//        public void testSet(){
//            //添加
//            jedis.sadd("user","liuling");
//            jedis.sadd("user","xinxin");
//            jedis.sadd("user","ling");
//            jedis.sadd("user","zhangxinxin");
//            jedis.sadd("user","who");
//            //移除noname
//            jedis.srem("user","who");
//            System.out.println(jedis.smembers("user"));//获取所有加入的value
//            System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素
//            System.out.println(jedis.srandmember("user"));
//            System.out.println(jedis.scard("user"));//返回集合的元素个数
//        }
//
//
//        public void test() throws InterruptedException {
//            //jedis 排序
//            //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）
//            jedis.del("a");//先清除数据，再加入数据进行测试
//            jedis.rpush("a", "1");
//            jedis.lpush("a","6");
//            jedis.lpush("a","3");
//            jedis.lpush("a","9");
//            System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]
//            System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果
//            System.out.println(jedis.lrange("a",0,-1));
//        }


        public void testRedisPool() {
            RedisUtil.getJedis().set("newname", "中文测试");
            System.out.println(RedisUtil.getJedis().get("newname"));
        }
}
