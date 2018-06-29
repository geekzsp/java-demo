package com.zsp.design.patterns.demo4;

/**
 * 建造模式
 *建造模式是对象的创建模式。建造模式可以将一个产品的
 * 内部表象（internal representation）与产品的生产过程分割开来，
 * 从而可以使一个建造过程生成具有不同的内部表象的产品对象。
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
