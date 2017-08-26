package until.redis;

import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.ShardedJedis;

import java.util.Collections;
import java.util.Set;

/**
 * Created by zy on 17-7-17.
 */


public class Redis {

    public static String get(String key) {
        String result = null;
        Jedis jedis = null;
        try {
            jedis = JedisPool.getJedis();
            result = jedis.get(key);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            JedisPool.returnJedis(jedis);
        }
        return result;
    }


    public static void set(String key, String v)
    {
        Jedis jedis = null;
        try {
            jedis = JedisPool.getJedis();
            jedis.set(key,v);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            JedisPool.returnJedis(jedis);
        }
    }


    public static void zadd(String key, double score, String member){
        Jedis jedis = null;
        try {
            jedis = JedisPool.getJedis();
            jedis.zadd(key,score,member);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            JedisPool.returnJedis(jedis);
        }
    }


    public static void zrem(String key, String... members){
        Jedis jedis = null;
        try {
            jedis = JedisPool.getJedis();
            jedis.zrem(key,members);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            JedisPool.returnJedis(jedis);
        }
    }


    public static String zrange(String key, long start, long end){
        Jedis jedis = null;
        try {
            jedis = JedisPool.getJedis();
            jedis.zrange(key,start,end);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            JedisPool.returnJedis(jedis);
        }
        return key;
    }

    public Set<String> getKeys(){
        Jedis jedis = null;
        Set<String> set = null;
        try {
            jedis = JedisPool.getJedis();
            set = jedis.keys("*");
            return set;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return set;
    }

    public static String exists(String key) {
        Jedis shardedJedis=null;
        try {
            shardedJedis=JedisPool.getJedis();
            shardedJedis.exists(key);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            JedisPool.returnJedis(shardedJedis);
        }
        return key;
    }
//    private ShardedJedis shardedJedis;


/*
    public static void main(String[] args) {
        JedisPool.createpool();
        Redis redis = new Redis();
//        redis.getKeys();
        for (String s:redis.getKeys()){
            System.out.println(s);
        }
    }
*/

}
