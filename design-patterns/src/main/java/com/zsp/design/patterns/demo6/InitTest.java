package com.zsp.design.patterns.demo6;

/**
 * @author zhangshipeng
 * 2019-03-11
 */
public class InitTest {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLO_WORLD);
    }
}

class ConstClass{
    public static final String HELLO_WORLD="hello-world";
    static {
        System.out.println("Constclass被初始化了");
    }
}
