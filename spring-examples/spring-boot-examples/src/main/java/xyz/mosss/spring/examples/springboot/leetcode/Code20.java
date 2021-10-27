package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class Code20 {
    public static boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<String> stack = new Stack<>();
        HashMap<String, String> hashMap = new HashMap();
        hashMap.put(")", "(");
        hashMap.put("}", "{");
        hashMap.put("]", "[");

        for (char aChar : chars) {
            String str=String.valueOf(aChar);
            if (!hashMap.containsKey(str)) {
                //不包含说明是左括号 压入栈
                stack.push(str);
                //右括号需要和栈弹出的元素对比
            } else if (stack.isEmpty() || !hashMap.get(str).equals(stack.pop())) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("{}"));
        System.out.println(isValid("{[}"));
        System.out.println(isValid("[][]()"));
    }
}