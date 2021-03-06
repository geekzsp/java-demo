package com.zsp.design.patterns.demo1;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class AmdCpu implements Cpu {
    /**
     * 针脚数
     */
    private int pins;

    public AmdCpu(int pins) {
        this.pins = pins;
    }

    /**
     * 计算
     */
    public void calculate() {
        System.out.println("Amd针脚数：" + pins);
    }
}
