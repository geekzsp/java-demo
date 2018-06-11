package com.zsp.design.patterns.demo2;


/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class IntelCpu implements Cpu {
    /**
     * CPU的针脚数
     */
    private int pins;

    public IntelCpu(int pins) {
        this.pins = pins;
    }

    /**
     * 计算
     */
    public void calculate() {
        System.out.println("IntelCpu的针脚数：" + pins);
    }
}
