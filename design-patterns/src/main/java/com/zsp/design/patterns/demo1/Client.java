package com.zsp.design.patterns.demo1;

/**
 * 简单工厂模式
 * @author: zhangshipeng
 * 2018/6/11
 */
public class Client {
    public static void main(String[] args) {
        ComputerEngineer computerEngineer = new ComputerEngineer();
        computerEngineer.makeComputer(1, 1);
    }

}
