package com.zsp.design.patterns.demo10;

/**
 * 门面模式/门面模式
 * 外观模式（ComputerFacade）,他隐藏了系统的复杂性，并向客户端提供了一个可以访问系统的接口。这种类型的设计模式属于结构性模式。
 * 为子系统中的一组接口提供了一个统一的访问接口，这个接口使得子系统更容易被访问或者使用。
 *
 * @author: zhangshipeng
 * 2018/6/13
 */
public class Client {
    public static void main(String[] args) throws InterruptedException {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.start();
        Thread.sleep(2000);
        computerFacade.shutdown();
    }
}
