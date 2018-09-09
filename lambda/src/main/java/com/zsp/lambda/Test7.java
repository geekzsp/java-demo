package com.zsp.lambda;

/**
 * @author: zhangshipeng
 * 2018-09-08
 */

@FunctionalInterface
interface IMath {
    int add(int x, int y);
}

public class Test7 {
    public static void main(String[] args) {
        Test7 test7 = new Test7();
        test7.test((x, y) -> x + y);

    }

    public void test(IMath iMath) {

    }
}
