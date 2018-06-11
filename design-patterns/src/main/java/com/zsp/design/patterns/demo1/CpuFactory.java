package com.zsp.design.patterns.demo1;

/**
 * @author: zhangshipeng
 * 2018/6/11
 */
public class CpuFactory {
    private static final int INTEL = 1;
    private static final int AMD = 2;

    public static Cpu createCpu(int type) {
        Cpu cpu = null;
        if (type == INTEL) {
            cpu = new IntelCpu(755);
        } else if (type == AMD) {
            cpu = new AmdCpu(938);
        }
        return cpu;
    }
}
