package com.zsp.design.patterns.demo7_3;

/**
 * 桥接模式
 *
 * @author: zhangshipeng
 * 2018/6/12
 */
public class Client {
    public static void main(String[] args) {
        Bridge bridge = new MyBridge();

        Driver mysqlDriver = new MysqlDriver();
        bridge.setDriver(mysqlDriver);
        bridge.connect();

        Driver sqlServerDriver = new SqlServerDriver();
        bridge.setDriver(sqlServerDriver);
        bridge.connect();
    }
}
