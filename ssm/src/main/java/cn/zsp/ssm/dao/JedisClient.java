package cn.zsp.ssm.dao;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2016/12/11
 */
public interface JedisClient {
    String get(String key);
    String set(String key, String value);
    String hget(String hkey, String key);
    long hset(String hkey, String key, String value);
    long incr(String key);
    long expire(String key, int second);
    long ttl(String key);
    long del(String key);
    long hdel(String hkey, String key);

}
