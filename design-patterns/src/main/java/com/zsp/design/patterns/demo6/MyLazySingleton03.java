package com.zsp.design.patterns.demo6;

/**
 * @author zhangshipeng
 * 2019-03-07
 */
public class MyLazySingleton03 {
    private MyLazySingleton03() {

    }
    static class MyLazySingleton03Holder {
        static MyLazySingleton03 myLazySingleton03 = new MyLazySingleton03();
    }
    public static MyLazySingleton03 getInstance() {
        return MyLazySingleton03Holder.myLazySingleton03;
    }

}
