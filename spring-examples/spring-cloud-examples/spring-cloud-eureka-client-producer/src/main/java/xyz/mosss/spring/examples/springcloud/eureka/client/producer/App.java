package xyz.mosss.spring.examples.springcloud.eureka.client.producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author moss
 * @date 2020/6/2
 */
@SpringBootApplication
@EnableEurekaClient
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

}