package xyz.mosss.spring.examples.springcloud.eureka.client.customer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author moss
 * @date 2020/6/2
 */
@FeignClient(name = "PRODUCER-EXAMPLE")
public interface Remote {
    @GetMapping( "/hello/{name}")
    String hello(@PathVariable String name);
}