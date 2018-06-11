package com.zsp.design.patterns.demo4;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class Product {
    /**
     * 定义一些关于产品的操作
     */
    private String part1;

    private String part2;

    public String getPart1() {
        return part1;
    }

    public Product setPart1(String part1) {
        this.part1 = part1;
        return this;
    }

    public String getPart2() {
        return part2;
    }

    public Product setPart2(String part2) {
        this.part2 = part2;
        return this;
    }
}
