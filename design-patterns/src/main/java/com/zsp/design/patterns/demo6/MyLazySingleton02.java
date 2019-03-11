package com.zsp.design.patterns.demo6;

/**
 * @author zhangshipeng
 * 2019-03-07
 */
public class MyLazySingleton02 {
    private static volatile MyLazySingleton02 myLazySingleton02 = null;

    private MyLazySingleton02() {
    }

    public static MyLazySingleton02 getInstance() {
        if (myLazySingleton02 == null) {
            synchronized (MyLazySingleton02.class) {
                if (myLazySingleton02 == null) {
                    myLazySingleton02 = new MyLazySingleton02();
                }
            }
        }
        return myLazySingleton02;
    }
}
