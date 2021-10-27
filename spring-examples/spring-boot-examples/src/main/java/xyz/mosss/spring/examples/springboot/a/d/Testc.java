package xyz.mosss.spring.examples.springboot.a.d;

import java.util.concurrent.CountDownLatch;

public class Testc {
    static int a = 0;

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                  a++;
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println(a);
    }
}