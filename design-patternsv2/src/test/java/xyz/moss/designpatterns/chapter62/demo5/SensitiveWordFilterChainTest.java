package xyz.moss.designpatterns.chapter62.demo5;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.moss.designpatterns.BaseTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */

class SensitiveWordFilterChainTest extends BaseTest {
    @Autowired
    private SensitiveWordFilterChain sensitiveWordFilterChain;
    @Test
    void filter() {
        Assertions.assertThat(sensitiveWordFilterChain.filter("haha")).isEqualTo(true);
        Assertions.assertThat(sensitiveWordFilterChain.filter("黄色")).isEqualTo(false);
        Assertions.assertThat(sensitiveWordFilterChain.filter("政治")).isEqualTo(false);
        Assertions.assertThat(sensitiveWordFilterChain.filter("广告")).isEqualTo(false);
    }
}