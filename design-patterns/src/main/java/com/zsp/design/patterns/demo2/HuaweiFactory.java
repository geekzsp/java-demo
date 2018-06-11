package com.zsp.design.patterns.demo2;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class HuaweiFactory implements AbstractFactory {
    /**
     * 创建CPU
     */
    @Override
    public Cpu crateCpu() {
        return new IntelCpu(666);
    }

    /**
     * 创建主板
     */
    @Override
    public MainBoard createMainBoard() {
        return new IntelMainBoard(666);
    }

    /**
     * 创建内存条
     *
     * @return
     */
    @Override
    public Memory createMemory() {
        return new SamsungeMemory();
    }
}
