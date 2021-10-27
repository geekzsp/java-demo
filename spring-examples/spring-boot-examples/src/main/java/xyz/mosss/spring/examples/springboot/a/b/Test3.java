package xyz.mosss.spring.examples.springboot.a.b;

import java.util.concurrent.CountDownLatch;

public class Test3 {
    static int count = 0;
    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(2);
        new Thread1(countDownLatch).start();
        new Thread2(countDownLatch).start();
        countDownLatch.await();
    }
}

