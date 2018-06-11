package com.zsp.design.patterns.demo2;

/**
 * 抽象工厂模式
 * @author: zhangshipeng
 * 2018/6/11
 */
public class Client {
    public static void main(String[] args) {
        ComputerEngineer computerEngineer=new ComputerEngineer();
        //computerEngineer.makeComputer(new IntelFactory());
        //computerEngineer.makeComputer(new AmdFactory());
        computerEngineer.makeComputer(new HuaweiFactory());
    }
}
