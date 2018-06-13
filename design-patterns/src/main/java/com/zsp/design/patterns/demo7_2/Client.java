package com.zsp.design.patterns.demo7_2;

/**
 * 适配器模式：接口适配器/缺省适配模式
 * @author: zhangshipeng
 * 2018/6/12
 */
public class Client {
    public static void main(String[] args) {
        A a = new Ashili();
        a.a();
        a.d();
    }
}
