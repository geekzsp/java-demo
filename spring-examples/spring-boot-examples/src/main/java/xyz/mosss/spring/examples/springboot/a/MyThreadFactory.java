package xyz.mosss.spring.examples.springboot.a;

import java.util.concurrent.ThreadFactory;

public class MyThreadFactory  implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        return null;
    }
}