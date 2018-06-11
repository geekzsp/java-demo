package com.zsp.design.patterns.demo3;

/**
 * 工厂方法模式
 *
 * @author: zhangshipeng
 * 2018/6/11
 */
public class Client {
    public static void main(String[] args) {
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile financial = exportFactory.factory("financial");
        financial.exprot("");
    }
}
