package com.zsp.design.patterns.demo7_2;

/**
 * @author: zhangshipeng
 * 2018/6/12
 */
public interface A {
    void a();

    void b();

    void c();

    default void d() {
        System.out.println("默认实现");
    }
}
