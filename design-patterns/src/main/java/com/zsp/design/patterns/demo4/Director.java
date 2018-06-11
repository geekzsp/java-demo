package com.zsp.design.patterns.demo4;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class Director {
    /**
     * 持有当前需要的建造者对象
     */
    private Builder builder;

    /**
     * 构造方法 传入建造者对象
     * @param builder  建造者对象
     */
    public Director(Builder builder) {
        this.builder = builder;
    }

    /**
     * 具体建造方法
     */
    public  void construct(){
        builder.buildPart1();
        builder.buildPart2();
    }
}
