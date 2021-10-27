package xyz.mosss.spring.examples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OkController {
    //注入方式1
    //@Autowired
    //private MessageService messageService;
    //注入方式二
    //private  final MessageService messageService;
    //public OkController(MessageService messageService) {
    //    this.messageService = messageService;
    //}
    //注入方式三
    private  MessageService messageService;

    public MessageService getMessageService() {
        return messageService;
    }
    @Autowired
    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public OkController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping("ok")
    public String ok() {
        messageService.showId();
        return "ok";
    }
}
