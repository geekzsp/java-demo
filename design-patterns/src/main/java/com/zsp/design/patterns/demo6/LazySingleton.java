package com.zsp.design.patterns.demo6;

/**
 * 单例模式 懒汉模式
 * @author: zhangshipeng
 * 2018/6/11
 */
public class LazySingleton {
    private static LazySingleton instance = null;

    public static synchronized LazySingleton getInstance() {
        if (instance == null) {
            return new LazySingleton();
        }
        return instance;
    }
}
