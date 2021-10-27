package xyz.mosss.spring.examples.springboot;

import org.springframework.stereotype.Component;

/**
 * 注入方式二 通过构造函数注入
 */
@Component
public class InjectExample02 {
    private final MessageService messageService;

    /**
     * 当只有一个构造函数可以不加 @Autowired 多个构造函数需要明确指定
     */
    public InjectExample02(MessageService messageService) {
        this.messageService = messageService;
    }

    public void send() {
        messageService.showId();
    }
}
