package xyz.mosss.spring.examples.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Value("${value:32}")
    private String id;

    public MessageService() {
    }

    public void showId() {
        System.out.println("id is:" + id);
    }

}
