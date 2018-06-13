package com.zsp.design.patterns.demo7;

/**
 * @author: zhangshipeng
 * 2018/6/12
 */
public class Adapter extends Usber implements Ps2 {
    @Override
    public void isPs2() {
        isUsb();
    }
}
