package chapter2;

import org.junit.Test;

/**
 * @author: zhangshipeng
 * 2018/8/6
 */
public class Demo {

    @Test
    public void test1() {
        Domain domain = new Domain();
        System.out.println(domain);
        System.out.println(domain.name);
        System.out.println((int)domain.name);
        System.out.println((char)0);
    }
}
