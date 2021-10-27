package xyz.moss.designpatterns.chapter62.demo6.service.notification;

/**
 * @author zhangshipeng
 * @date 2021/2/2
 */
public interface MsgSender<T extends Message> {

    void send(T t);
}
