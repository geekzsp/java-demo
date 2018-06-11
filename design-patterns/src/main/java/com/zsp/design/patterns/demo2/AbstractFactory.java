package com.zsp.design.patterns.demo2;

/**
 * 抽象工程类
 *
 * @author: zhangshipeng
 * 2018/6/11
 */
public interface AbstractFactory {
    /**
     * 创建CPU
     */
    Cpu crateCpu();

    /**
     * 创建主板
     */
    MainBoard createMainBoard();

    /**
     * 创建内存条
     * @return
     */
    Memory createMemory();
}
