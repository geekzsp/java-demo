package xyz.moss.designpatterns.chapter62.demo5;

import org.springframework.stereotype.Service;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
@Service
public class PoliticalWordFilterImpl implements SensitiveWordFilter {
    /**
     * @param text
     * @return 是否符合法律
     */
    @Override
    public boolean doFilter(String text) {
        boolean legal = true;
        if (text.contains("政治")) {
            legal = false;
        }
        return legal;
    }
}
