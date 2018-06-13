package com.zsp.design.patterns.demo7_3;

/**
 * 桥梁类(抽象类)
 * @author: zhangshipeng
 * 2018/6/12
 */
public abstract class Bridge {
    private Driver driver;

    public void connect() {
        driver.connect();
    }

    public void setDriver(Driver driverTemp) {
        this.driver = driverTemp;
    }

    public Driver getDriver() {
        return this.driver;
    }
}
