package xyz.moss.designpatterns.chapter62.demo5;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
@Service
@RequiredArgsConstructor
public class Demo {
    private final SensitiveWordFilterChain sensitiveWordFilterChain;

    public void testDemo() {
        boolean legal = sensitiveWordFilterChain.filter("😄哈哈");
        if (!legal) {
            System.out.println("不符合法律拒绝");
        }
    }
}
