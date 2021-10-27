package xyz.mosss.spring.examples.springboot.controller;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.mosss.spring.examples.springboot.Person;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangshipeng
 * @date 2020/9/30
 */
@RestController
@RequestMapping("redis")
public class RedisTestController {
    @Autowired
    ApplicationContext applicationContext;

    @Autowired
    private RedisTemplate<String, Integer> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private Person person;
    @Autowired
    private RedisTemplate<String, Person> personRedisTemplate;

    @GetMapping("set")
    public String set() {
        //System.out.println(person.getAge());
        //String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        //redisTemplate.opsForValue().set("d", 4);
        //redisTemplate.opsForValue().get("e");
        //
        //GeoOperations<String, String> stringStringGeoOperations = stringRedisTemplate.opsForGeo();
        //redisTemplate.opsForValue().get("d");
        //personRedisTemplate.opsForValue().set("person1", person);
        //Person person1 = personRedisTemplate.opsForValue().get("person1");
        //
        //stringRedisTemplate.opsForValue().setIfPresent()
        Boolean aBoolean = stringRedisTemplate.opsForValue().setIfAbsent("f", "f1");
        return aBoolean + "";
    }

    public static void main(String[] args) throws IOException {
        //Person person = new Person(12);
        ObjectMapper mapper = new ObjectMapper();
        //String s = mapper.writeValueAsString(person);
        //System.out.println(s);
        //Person person1 = mapper.readValue(s, Person.class);
        //System.out.println(person1);
        //Object o = mapper.readValue(s, Object.class);
        //System.out.println(o);

        //mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.PROPERTY);
        //
        //String json = "{\"@class\":\"xyz.mosss.spring.examples.springboot.Person\",\"name\":null,\"age\":21}";
        //byte[] bytes = json.getBytes();
        //Object o1 = mapper.readValue(bytes, Object.class);
        //System.out.println(o1);
        //Person person21 = (Person) o1;
        //System.out.println(person21);
        //
        //Boolean aBoolean = null;
        // String a=aBoolean + "123";
        //System.out.println(a);

        Integer a = 1;
        Integer b = 2;
        Integer c = null;
        Boolean flag = false;
        Integer result = (flag ? a * b : c);
        System.out.println(result);

    }
}
