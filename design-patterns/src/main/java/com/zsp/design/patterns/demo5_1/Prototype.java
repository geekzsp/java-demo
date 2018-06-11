package com.zsp.design.patterns.demo5_1;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public interface Prototype {
    Prototype clone();

    String getName();

    void setName(String name);
}
