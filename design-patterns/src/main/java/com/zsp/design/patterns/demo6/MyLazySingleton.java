package com.zsp.design.patterns.demo6;

/**
 * @author zhangshipeng
 * 2019-03-07
 */
public class MyLazySingleton {
    private static MyLazySingleton myLazySingleton = null;

    private MyLazySingleton() {

    }

    public synchronized static MyLazySingleton getInstance() {
        if (myLazySingleton == null) {
            myLazySingleton = new MyLazySingleton();
        }
        return myLazySingleton;
    }
}
