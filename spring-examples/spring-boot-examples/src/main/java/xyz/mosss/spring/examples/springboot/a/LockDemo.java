package xyz.mosss.spring.examples.springboot.a;

import java.math.BigDecimal;
import java.util.concurrent.*;

public class LockDemo {
    public static void main(String[] args) throws InterruptedException {
        //Lock lock=new ReentrantLock();
        //lock.lockInterruptibly();
        Thread thread = new Thread() {
            @Override
            public void run() {
              while (true){
                  try {
                      if(this.isInterrupted()){
                          System.out.println("线程被中断了");
                      }
                      Thread.sleep(5000);
                  } catch (InterruptedException e) {
                      System.out.println("睡眠被中断了");
                      e.printStackTrace();
                  }
              }
            }
        };
        thread.start();
        Thread.interrupted();
        thread.interrupt();
        Thread.sleep(1000);
        int a=1111111111;
        float b=a;
        System.out.println(a);
        System.out.println(b);

        double a1=1.0;
        double b1=0.9;
        System.out.println(a1-b1);//0.09999999999999998
        BigDecimal bigDecimal = new BigDecimal(0.9);
        BigDecimal bigDecimal1 = new BigDecimal(0.1);
        System.out.println(bigDecimal.subtract(bigDecimal1));//0.8000000000000000166533453693773481063544750213623046875

        BigDecimal bigDecimal2 = new BigDecimal("0.9");
        BigDecimal bigDecimal3 = new BigDecimal("0.1");
        System.out.println(bigDecimal2.subtract(bigDecimal3));//0.8

        BigDecimal bigDecimal4 = BigDecimal.valueOf(0.9);
        BigDecimal bigDecimal5 = BigDecimal.valueOf(0.1);
        System.out.println(bigDecimal4.subtract(bigDecimal5));//0.8

        Integer a2=null;
        int b2=a2;
        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return null;
            }
        };

    }

}