package xyz.mosss.spring.examples.springboot.a.d;

import java.util.concurrent.Executors;

public class Demo {
    static final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    public static void setData(String data) {
        Executors.newCachedThreadPool();
        threadLocal.set(data);
    }

    public static String getData() {
        return threadLocal.get();
    }

}