package cn.zsp.ssm.controller;

import cn.zsp.ssm.dao.JedisClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Description:
 * @Author: 张士鹏
 * @blog: http://blog.csdn.net/mixi9760
 * @CreateDate: 2017/4/1
 */
@SuppressWarnings("ALL")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext-*.xml", "classpath:spring/springmvc.xml"})
public class RedisTest {
    private static final Logger logger= LoggerFactory.getLogger(RedisTest.class);
    @Autowired
    JedisClient jedisClient;
    @Test
    public void testRedis(){
        jedisClient.set("a","100");
        String a = jedisClient.get("a");
        logger.info("a={}",a);
    }
}
