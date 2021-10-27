package xyz.mosss.spring.examples.springcloud.eureka.client.producer;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moss
 * @date 2020/6/2
 */
@RestController
public class HelloController {
    @GetMapping("hello/{name}")
    public String hello(@PathVariable String name) {
        return name;
    }
}