package com.zsp.design.patterns.demo10;

/**
 * 门面
 *
 * @author: zhangshipeng
 * 2018/6/13
 */
public class ComputerFacade {
    public void start() {
        System.out.println("computer start");
        Cpu cpu = new Cpu();
        cpu.start();
        Disk disk = new Disk();
        disk.start();
        Memory memory = new Memory();
        memory.start();
    }
    public void shutdown() {
        System.out.println("computer shutdown");
        Cpu cpu = new Cpu();
        cpu.shutdown();
        Disk disk = new Disk();
        disk.shutdown();
        Memory memory = new Memory();
        memory.shutdown();
    }
}
