package com.zsp.design.patterns.demo8;

/**
 * @author: zhangshipeng
 * 2018/6/12
 */
public class MysqlDriver implements  Driver {
    @Override
    public void connect() {
        System.out.println("连接Mysql数据库");
    }
}
