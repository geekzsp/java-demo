package com.zsp.lambda;

/**
 * @author: zhangshipeng
 * 2018-09-08
 */
public class Test3 {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        }).start();

        new Thread(() -> System.out.println()).start();


    }
}
