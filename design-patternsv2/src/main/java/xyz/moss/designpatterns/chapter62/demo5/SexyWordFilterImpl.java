package xyz.moss.designpatterns.chapter62.demo5;

import org.springframework.stereotype.Service;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
@Service
public class SexyWordFilterImpl implements SensitiveWordFilter {
    @Override
    public boolean doFilter(String text) {
        boolean legal=true;
        if (text.contains("黄色")) {
            legal = false;
        }
        return legal;
    }
}
