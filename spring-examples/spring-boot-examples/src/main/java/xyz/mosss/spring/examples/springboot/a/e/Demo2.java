package xyz.mosss.spring.examples.springboot.a.e;

public class Demo2 {
    static int count = 0;

    /**
     * 方式2  synchronized + wait() +notify()
     *  count % 2 != 0
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (Demo2.class) {
                    if (count % 2 != 0) {
                        try {
                            Demo2.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程A" + count++);
                    Demo2.class.notify();
                }
            }
        }).start();
        new Thread(() -> {
            while (count < 100) {
                synchronized (Demo2.class) {
                    if (count % 2 == 0) {
                        try {
                            Demo2.class.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println("线程B" + count++);
                    Demo2.class.notify();
                }
            }
        }).start();
    }
}