package com.zsp.design.patterns.demo4;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class ConcreteBuilder implements Builder {
    private Product product = new Product();


    /**
     * 构建零件1
     */
    @Override
    public void buildPart1() {
        product.setPart1("编号：9257");
    }

    /**
     * 构建零件2
     */
    @Override
    public void buildPart2() {
        product.setPart2("名称：XXX");
    }

    /**
     * 产品返回方法
     */
    @Override
    public Product retrieveResult() {
        return product;
    }
}
