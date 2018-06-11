package com.zsp.design.patterns.demo6;

/**
 * 双重检查加锁
 * 被volatile修饰的变量的值，将不会被本地线程缓存，所有对该变量的读写都是直接操作共享内存，从而确保多个线程能正确的处理该变量。
 * @author: zhangshipeng
 * 2018/6/11
 */
public class LazySingleton2 {
    private volatile static LazySingleton2 instance = null;

    public static LazySingleton2 getInstance() {
        if (instance == null) {
            //同步块，线程安全的创建实例
            synchronized (LazySingleton2.class) {
                //再次检查实例是否存在，如果不存在才真正的创建实例
                if (instance == null) {
                    return new LazySingleton2();
                }
            }
        }
        return instance;
    }
}
