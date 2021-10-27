package xyz.mosss.spring.examples.springcloud.eureka.client.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moss
 * @date 2020/6/2
 */
@RestController
public class TestHelloController {
    @Autowired
    Remote remote;

    @GetMapping("/testHello")
    public String testHello() {
        return remote.hello("abc");
    }
}