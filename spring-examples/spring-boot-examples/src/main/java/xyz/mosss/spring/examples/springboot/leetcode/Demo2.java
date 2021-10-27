package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Demo2 {
    public static void main(String[] args) {
        //判断 是不是2的几次幂
        System.out.println(isPowerOfTwo(4));
        System.out.println(isPowerOfTwo(5));
        System.out.println(isPowerOfTwo(1));
        System.out.println(isPowerOfTwo(0));
        System.out.println("暴力法");
        //int a = 1;
        //int b = 3;
        //System.out.println(a > 0 && b > 0);
        //System.out.println(a > 0 & b > 0);
        //System.out.println(a & b);
        System.out.println(isPowerOfTwoV2(4));
        System.out.println(isPowerOfTwoV2(5));
        System.out.println(isPowerOfTwoV2(1));
        //System.out.println(isPowerOfTwoV2(0));

        System.out.println(0%2);
        System.out.println(0/2);
    }


    public static boolean isPowerOfTwo(int n) {
        //return n > 0 & (n & (n - 1)) == 0;
        return n==(n&(-n));
    }

    public static boolean isPowerOfTwoV2(int n) {
        AtomicLong atomicLong = new AtomicLong();
        atomicLong.getAndIncrement();
        atomicLong.incrementAndGet();
        atomicLong.getAndSet(1);
        atomicLong.updateAndGet(x -> 5);

        LongAdder longAdder=new LongAdder();
        longAdder.increment();
        longAdder.decrement();
        longAdder.longValue();
        longAdder.increment();
        while (n % 2 == 0) {
            n = n / 2;
        }
        return n == 1;
    }


}