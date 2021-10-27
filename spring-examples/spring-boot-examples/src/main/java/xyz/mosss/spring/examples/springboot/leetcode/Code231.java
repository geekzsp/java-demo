package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Code231 {
    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public static void main(String[] args) {
        System.out.println(-4%2);
        System.out.println(isPowerOfTwo(-3));
        System.out.println(isPowerOfTwo(0));
        System.out.println(isPowerOfTwo(-4));
        System.out.println(isPowerOfTwo(3));
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(50));
        System.out.println(isPowerOfTwo(64));
        System.out.println(1&2);
        System.out.println(2&3);
        System.out.println(2&2);
        System.out.println(-2);
        System.out.println(~2);

    }
}