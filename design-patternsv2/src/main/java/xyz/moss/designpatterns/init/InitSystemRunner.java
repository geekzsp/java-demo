package xyz.moss.designpatterns.init;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author zhangshipeng
 * @date 2021/1/26
 */
@Component
public class InitSystemRunner implements CommandLineRunner {
    /**
     * Callback used to run the bean.
     * @param args incoming main method arguments
     * @throws Exception on error
     */
    @Override
    public void run(String... args) throws Exception {
        System.out.println("系统启动中 【初始化配置信息】");
    }
}
