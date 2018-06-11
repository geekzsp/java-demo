package com.zsp.design.patterns.demo6;

/**
 *
 * 单例模式 饿汉模式
 * @author: zhangshipeng
 * 2018/6/11
 */
public class EagerSingleton {
    private static EagerSingleton instance = new EagerSingleton();

    private EagerSingleton() {
    }

    /**
     * 静态工厂方法
     */
    public static EagerSingleton getInstance() {
        return instance;
    }
}
