package xyz.moss.designpatterns.chapter62.demo3;

/**
 *
 * 责任链变种 每个处理器都执行一遍 链表方式实现
 * @author zhangshipeng
 * @date 2021/1/28
 */
public class Demo {
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new HandlerA());
        handlerChain.addHandler(new HandlerB());
        handlerChain.handle();
    }
}
