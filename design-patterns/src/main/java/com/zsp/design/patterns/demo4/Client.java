package com.zsp.design.patterns.demo4;

/**
 * 建造模式
 * @author: zhangshipeng
 * 2018/6/11
 */
public class Client {
    public static void main(String[] args) {
        Builder builder=new ConcreteBuilder();
        Director director=new Director(builder);
        director.construct();
        Product product = builder.retrieveResult();
        System.out.println(product.getPart1());
        System.out.println(product.getPart2());
    }
}
