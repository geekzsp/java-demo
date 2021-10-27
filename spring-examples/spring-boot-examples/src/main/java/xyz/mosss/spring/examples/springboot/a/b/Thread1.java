package xyz.mosss.spring.examples.springboot.a.b;

import java.util.concurrent.CountDownLatch;

public class Thread1 extends Thread {
    CountDownLatch countDownLatch;
    public Thread1(CountDownLatch countDownLatch) {
        this.countDownLatch=countDownLatch;
    }

    @Override
    public void run() {
        while (Test3.count < 20) {
            synchronized (Test3.object) {
                if (Test3.count % 2 != 0) {
                    try {
                        Test3.object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("线程A:" + Test3.count);
                Test3.count++;
                Test3.object.notify();
            }
        }
        countDownLatch.countDown();
    }
}