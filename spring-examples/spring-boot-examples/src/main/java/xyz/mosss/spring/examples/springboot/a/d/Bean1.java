package xyz.mosss.spring.examples.springboot.a.d;

public class Bean1 {
    public static String a = "1";


    public static Bean1 instance = new Bean1();

    static {
        System.out.println("bean1 测试");
    }

    public static Bean1 getInstance() {
        return Bean1.instance;
    }
}