package xyz.mosss.spring.examples.springboot;

/**
 * @author moss
 * @date 2020/6/1
 */
public class Demo2 {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyRunable(), "线程1");
        Thread thread2 = new Thread(new MyRunable(), "线程2");
        Thread thread3 = new Thread(new MyRunable(), "线程3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}