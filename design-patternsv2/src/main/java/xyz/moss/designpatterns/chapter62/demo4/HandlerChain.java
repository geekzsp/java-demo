package xyz.moss.designpatterns.chapter62.demo4;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
public class HandlerChain {
    private final List<Handler> handlerList = Lists.newArrayList();

    public void addHandler(Handler handler) {
        handlerList.add(handler);
    }

    public void handle() {
        for (Handler handler : handlerList) {
            handler.handle();
        }
    }
}
