package xyz.mosss.spring.examples.springboot.sort;

import com.google.common.collect.Lists;
import xyz.mosss.spring.examples.springboot.Person;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangshipeng
 * @date 2020/12/16
 */
public class Demo {

    public static void main(String[] args) {
        Person person1=new Person("A张三",15);
        Person person2=new Person("C李四",16);
        Person person3=new Person("B王五",15);


        List<Person> personList= Lists.newArrayList(person1,person2,person3);
        Collections.sort(personList);
        //Arrays.sort();
        //personList.sort(null);
        personList.sort(Comparator.comparing(Person::getAge).thenComparing(Person::getName));
        System.out.println(personList);

    }
}
