package xyz.moss.designpatterns;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import xyz.moss.designpatterns.demo.OkController;

import java.net.URI;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * @author zhangshipeng
 * @date 2021/1/26
 */
@SpringBootTest
class Test01 {

    @Test
    public void test() throws InterruptedException {
        while (true) {
            try {
                System.out.println("begin");
                RestTemplate restTemplate = new RestTemplate();
                URI uri = UriComponentsBuilder.fromUriString("http://localhost:8081/{a}")
                        .build("123");
                String forObject = restTemplate.getForObject(uri, String.class);
                //System.out.println(forObject);

            } catch (Exception e) {
                //e.printStackTrace();
                Thread.sleep(1000);
            }
        }
    }
}