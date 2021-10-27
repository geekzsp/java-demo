package xyz.moss.designpatterns.chapter62.demo2;



/**
 *
 * 责任链 数组方式实现
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
