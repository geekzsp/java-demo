package com.zsp.design.patterns.demo4_1;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class Client {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Builder builder = new WelcomeBuilder();
        Director director = new Director(builder);
        director.construct("toAddress@126.com", "fromAddress@126.com");

    }

}