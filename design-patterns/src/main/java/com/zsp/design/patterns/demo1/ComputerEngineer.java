package com.zsp.design.patterns.demo1;

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

    public void makeComputer(int cpuType, int mainBoardType) {
        //step1:首先准备好组装机需要的零件
        prepareHardwares(cpuType, mainBoardType);
        //step2:组装机器
        //step3:测试机器
        //step4：交付客户
    }

    private void prepareHardwares(int cpuType, int mainBoardType) {
        cpu = CpuFactory.createCpu(cpuType);
        mainBoard = MainBoardFactory.createMainBoard(mainBoardType);
        //测试
        cpu.calculate();
        mainBoard.installCpu();
    }
}
