package com.zsp.lambda.stream;

import java.util.stream.IntStream;

/**
 * @author: zhangshipeng
 * 2018-09-08
 */
public class Test1 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        /*
         * map中间操作  返回流的操作
         * sum终止操作
         * */
        int sum = IntStream.of(nums).map(i -> i * 2).sum();
        System.out.println(sum);
    }


}
