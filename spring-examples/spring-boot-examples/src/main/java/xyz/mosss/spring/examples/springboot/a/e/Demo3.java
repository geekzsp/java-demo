package xyz.mosss.spring.examples.springboot.a.e;

public class Demo3 {
    static int count = 0;

    /**
     * 方式3  synchronized + wait() +notify()
     *     线程交替
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (Demo3.class) {
                    System.out.println("线程A" + count++);
                    Demo3.class.notify();
                    try {
                        Demo3.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (count < 100) {
                synchronized (Demo3.class) {
                    System.out.println("线程B" + count++);
                    Demo3.class.notify();
                    try {
                        Demo3.class.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}