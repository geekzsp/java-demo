package xyz.moss.designpatterns.chapter62.demo5;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
@Service
@RequiredArgsConstructor
public class SensitiveWordFilterChain {

    private final List<SensitiveWordFilter> filterList;


    /**
     * @param text
     * @return true：符合法律 false：不符合
     */
    public boolean filter(String text) {
        for (SensitiveWordFilter sensitiveWordFilter : filterList) {
            boolean legal = sensitiveWordFilter.doFilter(text);
            if (!legal) {
                //  不符合法律
                return false;
            }
        }
        return true;
    }


}
