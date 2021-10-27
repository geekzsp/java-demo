package xyz.mosss.spring.examples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 注入方式一 通过属性注入
 */
@Component
public class InjectExample01 {
    @Autowired
    private MessageService messageService;

    public void send() {
        messageService.showId();
    }
}
