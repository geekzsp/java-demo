package xyz.mosss.spring.examples.framework;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello,World");
        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring-content.xml");
        MessageService messageService = classPathXmlApplicationContext.getBean(MessageService.class);
        messageService.showId();
    }
}
