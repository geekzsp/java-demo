package com.zsp.design.patterns.demo2;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class AmdFactory implements  AbstractFactory {
    /**
     * 创建CPU
     */
    @Override
    public Cpu crateCpu() {
        return new AmdCpu(938);
    }

    /**
     * 创建主板
     */
    @Override
    public MainBoard createMainBoard() {
        return  new AmdMainBoard(938);
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
