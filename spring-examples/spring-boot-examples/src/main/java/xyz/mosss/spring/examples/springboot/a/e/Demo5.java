package xyz.mosss.spring.examples.springboot.a.e;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Demo5 {
    static int count = 0;
    static int max = 1000;
    static int threadNums = 3;

    static class MyThread extends Thread {
        private final Integer currentThreadNumber;

        public MyThread(Integer currentThreadNumber) {
            this.currentThreadNumber = currentThreadNumber;
        }

        @Override
        public void run() {
            while (count < max) {
                synchronized (Demo5.class) {
                    //System.out.println(count);
                    //System.out.println(currentThreadNumber);
                    while (count % threadNums != currentThreadNumber) {
                        try {
                            Demo5.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("当前线程:" + currentThreadNumber + ",count:" + count);
                    count++;
                    Demo5.class.notifyAll();
                }

            }
        }
    }

    /**
     * n个线程交替打印
     */
    public static void main(String[] args) throws InterruptedException {
        new MyThread(0).start();
        new MyThread(1).start();
        new MyThread(2).start();
        TimeUnit.HOURS.sleep(1);
    }
}