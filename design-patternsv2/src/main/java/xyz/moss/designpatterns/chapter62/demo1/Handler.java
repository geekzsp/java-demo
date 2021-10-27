package xyz.moss.designpatterns.chapter62.demo1;

/**
 * @author zhangshipeng
 * @date 2021/1/28
 */
public abstract class Handler {
    protected Handler next = null;

    public void setNext(Handler next) {
        this.next = next;
    }

    public final void handle() {
        boolean handled = doHandle();
        if (!handled && next != null) {
            next.handle();
        }
    }

    protected abstract boolean doHandle();

}
