package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.Arrays;

public class Code338 {
    public int[] countBits(int num) {
        int[] arr=new int[num];
        for(int i=0;i<arr.length;i++){
            arr[i]=getOneCount(i);
        }
        return arr;
    }


    public int getOneCount(int n){
        int count=0;
        while(n!=0){
            n=n&(n-1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] ints = new Code338().countBits(2);
        System.out.println(Arrays.toString(ints));
    }
}