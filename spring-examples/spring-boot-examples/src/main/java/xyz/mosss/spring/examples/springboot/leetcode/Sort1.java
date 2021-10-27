package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.Arrays;

public class Sort1 {
    public static int[] sort(int[] datas){
        for(int i=0;i<datas.length;i++){
            int maxIndex=i;
            for(int j=i;j<datas.length;j++){
                if(datas[j]>datas[maxIndex]){
                    maxIndex=j;
                }
            }
            int temp=datas[maxIndex];
            datas[maxIndex]=datas[i];
            datas[i]=temp;
        }
        return datas;
    }

    public static void main(String[] args) {
        int[] datas = {2, 1, 7, 5,0,  199,6,-3};
        int[] sort = sort(datas);
        System.out.println(Arrays.toString(sort));
    }
}