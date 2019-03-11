package thread;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangshipeng
 * 2018-12-25
 */
public class ThreadDemo {

    static class Thread1 extends Thread {
        @Override
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Thread1 正在运行" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Runnable1 implements Runnable {
        public void run() {
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("Runnable1 正在运行" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread1.setDefaultUncaughtExceptionHandler((t, e) -> {

        });
        for (int i = 0; i < 10; i++) {
            new Thread1().start();
            new Thread(new Runnable1()).start();
        }
        System.out.println("====");
    }
}
