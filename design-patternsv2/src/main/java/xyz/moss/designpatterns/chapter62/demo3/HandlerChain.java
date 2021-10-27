package xyz.moss.designpatterns.chapter62.demo3;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
public class HandlerChain {
    private Handler head;
    /**
     * 记录链尾是为了方便添加处理器
     */
    private Handler tail;

    public void addHandler(Handler handler) {
        //第一次处理器
        if (head == null) {
            head = handler;
            tail = handler;
            return;
        }
        //添加到链尾
        tail.setNext(handler);
        //记录新链尾
        tail = handler;
    }

    public void handle() {
        if (head != null) {
            head.handle();
        }
    }
}
