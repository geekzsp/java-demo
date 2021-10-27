import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import xyz.mosss.spring.examples.springboot.*;

import java.net.URI;

@SpringBootTest(classes = MainApplication.class)
public class MySpringBootTest {
    @Autowired
    private InjectExample01 injectExample01;
    @Autowired
    private InjectExample02 injectExample02;
    @Autowired
    private InjectExample03 injectExample03;
    @Test
    public void test() {
        injectExample03.send();
    }
}
