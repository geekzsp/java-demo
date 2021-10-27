package xyz.moss.designpatterns;

import com.alibaba.fastjson.JSON;
import com.google.common.util.concurrent.RateLimiter;

/**
 * @author zhangshipeng
 * @date 2021/1/27
 */
public class Test {
    @org.junit.jupiter.api.Test
    public void test(){
        String text = JSON.toJSONString(""); //序列化
    }
}
