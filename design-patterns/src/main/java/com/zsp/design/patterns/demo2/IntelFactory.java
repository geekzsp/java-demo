package com.zsp.design.patterns.demo2;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class IntelFactory implements AbstractFactory {


    /**
     * 创建CPU
     */
    @Override
    public Cpu crateCpu() {
        return new IntelCpu(755);
    }

    /**
     * 创建主板
     */
    @Override
    public MainBoard createMainBoard() {
        return new IntelMainBoard(755);
    }

    /**
     * 创建内存条
     *
     * @return
     */
    @Override
    public Memory createMemory() {
        return new KingstonMemory();
    }
}
