package xyz.mosss.spring.examples.springboot;

import org.apache.tomcat.jni.Time;

import java.util.concurrent.TimeUnit;

/**
 * @author moss
 * @date 2020/6/1
 */
public class MyRunable implements Runnable {
    @Override
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.getName() + "离开了");
    }
}