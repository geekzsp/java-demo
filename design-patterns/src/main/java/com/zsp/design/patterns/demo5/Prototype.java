package com.zsp.design.patterns.demo5;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public interface Prototype{
    /**
     * 克隆自身的方法
     * @return 一个从自身克隆出来的对象
     */
    Object clone();
}