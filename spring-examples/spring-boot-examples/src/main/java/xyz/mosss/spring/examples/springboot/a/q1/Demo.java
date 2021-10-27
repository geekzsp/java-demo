package xyz.mosss.spring.examples.springboot.a.q1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(1);

        executorService.submit(()->{
            int i=1/0;
        });

        executorService.submit(()->{
            System.out.println("当线程池抛出异常后继续新的任务");
        });
    }
}