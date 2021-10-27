package xyz.moss.designpatterns.chapter62.demo5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
@SpringBootTest
class DemoTest {
    @Autowired
    private Demo demo;

    @Test
    void testDemo() {
        demo.testDemo();
    }
}