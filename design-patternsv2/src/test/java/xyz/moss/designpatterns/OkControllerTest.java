package xyz.moss.designpatterns;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.moss.designpatterns.demo.OkController;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author zhangshipeng
 * @date 2021/1/26
 */
@SpringBootTest
class OkControllerTest {
    @Autowired
    private OkController okController;

    @Test
    void ok() {
       assertThat(okController.ok()).as("是否包含").contains("ok");
    }
}