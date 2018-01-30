package cn.zsp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Random;

@SpringBootApplication
@EnableScheduling
public class SpringbootApplication {

    public static void main(String[] args) {
        Random random = new Random();
        SpringApplication.run(SpringbootApplication.class, args);
    }
}
