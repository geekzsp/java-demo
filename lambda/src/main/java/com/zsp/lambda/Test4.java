package com.zsp.lambda;

import java.util.function.Function;

/**
 *
 * @FunctionalInterface 注解的接口只能有一个未实现的方法，但是可以有默认方法
 * @author: zhangshipeng
 * 2018-09-08
 */
@FunctionalInterface
interface Interfacetest {
    int runTest(int num);
    default  void test(){
        System.out.println("21");
    }
}

public class Test4 {
    public static void main(String[] args) {
        Interfacetest interfacetest1 = (i) -> i * 2;
        Interfacetest interfacetest2 = i -> i * 2;
        Interfacetest interfacetest3 = (i) -> {
            System.out.println("---");
            return i * 2;
        };
        int i1 = interfacetest1.runTest(5);
        int i2 = interfacetest2.runTest(5);
        int i3 = interfacetest3.runTest(5);
        System.out.println(i1);
        System.out.println(i2);
        System.out.println(i3);
    }
}
