package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.HashMap;

public class CodeAA {
   static HashMap<Integer, String> dict = new HashMap<>();

   static  {
        dict.put(10, "A");
        dict.put(11, "B");
        dict.put(12, "C");
        dict.put(13, "D");
        dict.put(14, "E");
        dict.put(15, "F");
    }

    public static void main(String[] args) {
        System.out.println(getData(256));
        System.out.println(getData(27));
        System.out.println(getData(2711));
        System.out.println(getData(27111));
    }

    public static String getData(int num) {
        StringBuffer sb = new StringBuffer();
        while (num > 0) {
            int val = num % 16;
            sb.append(swapNum(val));
            //sb.append(",");
            num = num / 16;
        }
        return sb.reverse().toString();
    }

    private static String swapNum(int val) {
        if (val < 10) {
            return val + "";
        }

        return dict.get(val);
    }
}