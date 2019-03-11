package com.zsp.design.patterns.demo6;

import java.util.Arrays;

/**
 * @author zhangshipeng
 * 2019-03-11
 */
public class MaoPaoPaiXu {
    public static void main(String[] args) {
        int[] nums = {11, 2, 23, 1, 99, 102, 66};
        int[] ints = maoPaoPaiXu(nums);
        System.out.println(Arrays.toString(ints));
    }

    private static  int[] maoPaoPaiXu(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-1-i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums;
    }
}
