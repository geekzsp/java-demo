package xyz.mosss.spring.examples.springboot.a.d;

import xyz.mosss.spring.examples.springboot.MyRunable;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class Test3 {
    //static AtomicLong a = new AtomicLong();
    static  int b = 0;
    //static  CountDownLatch countDownLatch = new CountDownLatch(20000);


    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 20000; i++) {
           new Thread(() -> {
               //for (int i1 = 1; i1 <= 1000; i1++) {

                   //a.incrementAndGet();
                   b++;
               //}
               //countDownLatch.countDown();
           }).start();
        }
        //countDownLatch.await();
        Thread.sleep(1000);
        //System.out.println(a.get());
        System.out.println(b);
    }
}