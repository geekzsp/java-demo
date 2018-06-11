package com.zsp.design.patterns.demo2;



/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class AmdMainBoard implements MainBoard {
    /**
     * CPU插槽孔数
     */
    private int cpuHoles;

    public AmdMainBoard(int cpuHoles) {
        this.cpuHoles = cpuHoles;
    }

    /**
     * 安装CPU
     */
    @Override
    public void installCpu() {
        System.out.println("Amd主板的CPU插槽孔数：" + cpuHoles);
    }
}
