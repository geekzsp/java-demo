package xyz.mosss.spring.examples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注入方式三 通过set方法注入
 */
@Component
public class InjectExample03 {
    private MessageService messageService;

    public InjectExample03() {

    }

    public MessageService getMessageService() {
        return messageService;
    }
    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.showId();
    }
}
