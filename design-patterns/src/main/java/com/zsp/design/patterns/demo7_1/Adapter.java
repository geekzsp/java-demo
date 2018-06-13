package com.zsp.design.patterns.demo7_1;

/**
 * @author: zhangshipeng
 * 2018/6/12
 */
public class Adapter implements Ps2 {
    private Usber usber;

    public Adapter(Usber usber) {
        this.usber = usber;
    }

    @Override
    public void isPs2() {
        usber.isUsb();
    }
}
