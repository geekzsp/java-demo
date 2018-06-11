package com.zsp.design.patterns.demo1;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class IntelMainBoard implements MainBoard {
    /**
     * CPU插槽孔数
     */
    private int cpuHoles;

    public IntelMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    /**
     * 安装CPU
     */
    public void installCpu() {
        System.out.println("Intel主板的CPU插槽孔数是：" + cpuHoles);
    }
}
