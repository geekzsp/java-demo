package xyz.mosss.spring.examples.springboot.a.d;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test {
    static CountDownLatch countDownLatch = new CountDownLatch(100);
    static int a;
    static volatile int b;
    static AtomicLong c = new AtomicLong(); //cas方案可以
    static int d; //synchronized 可以
    static int e; //lock 可以
    static Lock lock = new ReentrantLock();

    static class MyTestRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                a++;
                b++;
                c.incrementAndGet();
                incd();
                inde();
            }
            countDownLatch.countDown();
        }


    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(new MyTestRunnable()).start();
        }
        countDownLatch.await();
        System.out.println(a);
        System.out.println(b);
        System.out.println(c.get());
        System.out.println(d);
        System.out.println(e);
    }

    public static synchronized void incd() {
        d++;
    }

    public static void inde() {
        lock.lock();
        try {
            e++;
        } finally {
            lock.unlock();
        }
    }

}