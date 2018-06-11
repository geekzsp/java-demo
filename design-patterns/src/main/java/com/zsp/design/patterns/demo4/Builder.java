package com.zsp.design.patterns.demo4;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public interface Builder {
    /**
     * 构建零件1
     */
    void buildPart1();

    /**
     * 构建零件2
     */
    void buildPart2();

    /**
     * 产品返回方法
     */
    Product retrieveResult();
}
