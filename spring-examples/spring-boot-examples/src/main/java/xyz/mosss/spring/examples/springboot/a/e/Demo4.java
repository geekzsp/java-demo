package xyz.mosss.spring.examples.springboot.a.e;

import java.util.concurrent.TimeUnit;

public class Demo4 {
    volatile static int count = 0;
   volatile static boolean flag = true;

    /**
     * 方式3  volatile +标志位
     * 线程交替
     */
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (count < 100000) {
                if (flag) {
                    System.out.println("线程A" + count++);
                    flag = !flag;
                }
            }
        }).start();
        new Thread(() -> {
            while (count < 100000) {
                if (!flag) {
                    System.out.println("线程B" + count++);
                    flag = !flag;
                }
            }
        }).start();

        TimeUnit.HOURS.sleep(1);
    }
}