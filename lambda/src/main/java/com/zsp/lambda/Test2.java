package com.zsp.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author: zhangshipeng
 * 2018-09-08
 */
public class Test2 {
    public static void main(String[] args) {
        int[] nums = {100, 123, 1343, 5, 23, -2};
        //一般方式
        int min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num < min) {
                min = num;
            }
        }
        System.out.println(min);
        //方式二
        //List<Integer> integers = Arrays.asList(nums);
        //Integer min1 = Collections.min(integers);
        //System.out.println(min1);
        //lambda
        int asInt = IntStream.of(nums).min().getAsInt();
        System.out.println(asInt);
    }
}
