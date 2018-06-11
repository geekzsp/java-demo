package com.zsp.design.patterns.demo6;

/**
 * 一种更加高效的单例模式
 *
 * @author: zhangshipeng
 * 2018/6/11
 */
public class Singleton {
    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }
}
