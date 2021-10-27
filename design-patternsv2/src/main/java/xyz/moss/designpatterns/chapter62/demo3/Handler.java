package xyz.moss.designpatterns.chapter62.demo3;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
public abstract class Handler {
    protected Handler next = null;

    public void setNext(Handler next) {
        this.next = next;
    }

    public void handle() {
      doHandle();
        if (next != null) {
            next.handle();
        }
    }

    protected abstract void doHandle();

}
