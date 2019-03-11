package com.zsp.design.patterns.demo6;

/**
 * @author zhangshipeng
 * 2019-03-07
 */
public class MyEagerSingleton {
    private static MyEagerSingleton myEagerSingleton = new MyEagerSingleton();

    private MyEagerSingleton() {

    }

    public static MyEagerSingleton getInstance() {
        return myEagerSingleton;
    }
}
