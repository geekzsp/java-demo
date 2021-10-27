package xyz.mosss.spring.examples.springboot.a.e;

public class Demo1 {
    static int count = 0;

    /**
     * 方式1 只是用 synchronized
     * 效率低 造成很多空转 不是好方法
     */
    public static void main(String[] args) {
        new Thread(() -> {
            while (count < 100) {
                synchronized (Demo1.class) {
                    if (count % 2 == 0) {
                        System.out.println("线程A" + count++);
                    }
                }
            }
        }).start();
        new Thread(() -> {
            while (count < 100) {
                synchronized (Demo1.class) {
                    if (count % 2 != 0) {
                        System.out.println("线程B" + count++);
                    }
                }
            }
        }).start();
    }
}