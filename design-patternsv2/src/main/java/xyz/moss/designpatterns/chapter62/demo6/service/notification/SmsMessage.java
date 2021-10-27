package xyz.moss.designpatterns.chapter62.demo6.service.notification;

/**
 * 消息负载
 * @author zhangshipeng
 * @date 2021/2/2
 */
public class SmsMessage extends Message {

    private String phoneNumber;

    private String subject;

    private String context;
}
