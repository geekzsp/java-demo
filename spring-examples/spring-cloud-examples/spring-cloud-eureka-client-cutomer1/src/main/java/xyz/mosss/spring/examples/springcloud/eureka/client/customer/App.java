package xyz.mosss.spring.examples.springcloud.eureka.client.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author moss
 * @date 2020/6/2
 */
@SpringBootApplication
//@EnableEurekaClient 同 EnableDiscoveryClient 效果基本一种。 EnableDiscoveryClient 是spring cloud 对于所有注册发现的一种封装
@EnableDiscoveryClient
@EnableFeignClients
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }


}