package com.zsp.lambda;

import java.util.function.Function;

/**
 * @author: zhangshipeng
 * 2018-09-08
 */
public class Test8 {

    public static void main(String[] args) {
        /*
        * 级联表达式
        * 科里化：把多个参数的函数转换成只有一个参数的函数 科里化的目的是函数的标准化
        *
        * */
        Function<Integer, Function<Integer, Integer>> fun = x -> y -> x + y;

        System.out.println(fun.apply(5).apply(6));

    }
}
