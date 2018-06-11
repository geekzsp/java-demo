package com.zsp.design.patterns.demo2;


/**
 * 装机工程师
 *
 * @author: zhangshipeng
 * 2018/6/11
 */
public class ComputerEngineer {
    /**
     * 定义组装机需要的CPU
     */
    private Cpu cpu = null;

    /**
     * 定义组装机需要的主板
     */
    private MainBoard mainBoard = null;

    /**
     * 定义组装机需要的内存条
     */
    private Memory memory = null;

    public void makeComputer(AbstractFactory abstractFactory) {
        //step1:首先准备好组装机需要的零件
        prepareHardwares(abstractFactory);
        //step2:组装机器
        //step3:测试机器
        //step4：交付客户
    }

    private void prepareHardwares(AbstractFactory abstractFactory) {
        cpu = abstractFactory.crateCpu();
        mainBoard = abstractFactory.createMainBoard();
        memory = abstractFactory.createMemory();
        //测试
        cpu.calculate();
        mainBoard.installCpu();
        memory.run();

    }
}
