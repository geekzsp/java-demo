package com.zsp.design.patterns.demo6;

import java.util.Arrays;

/**
 * @author zhangshipeng
 * 2019-03-11
 */
public class XuanZhePaiXu {
    public static void main(String[] args) {
        int[] nums = {11, 2, 23, 1, 99, 102, 66};
        System.out.println("输入的值："+Arrays.toString(nums));
        int[] ints = xuanZhePaiXu(nums);
        System.out.println("最后结果："+Arrays.toString(ints));
    }

    public static int[] xuanZhePaiXu(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = nums[i];
                nums[i] = nums[minIndex];
                nums[minIndex] = temp;
            }
            System.out.println("第几次变："+Arrays.toString(nums));
        }
        return nums;
    }
}
