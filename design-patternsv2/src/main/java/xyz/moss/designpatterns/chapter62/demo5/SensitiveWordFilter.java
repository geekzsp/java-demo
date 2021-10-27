package xyz.moss.designpatterns.chapter62.demo5;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
public interface SensitiveWordFilter {
    /**
     * @param text
     * @return 是否符合法律
     */
    boolean doFilter(String text);
}
