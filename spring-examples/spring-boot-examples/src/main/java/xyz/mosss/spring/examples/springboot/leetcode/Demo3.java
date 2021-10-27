package xyz.mosss.spring.examples.springboot.leetcode;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.LongBinaryOperator;

public class Demo3 {
    public static void main(String[] args) {
        AtomicLong atomicLong=new AtomicLong();
        atomicLong.getAndUpdate(x->x+5);
        atomicLong.getAndAdd(6);
        atomicLong.incrementAndGet();
        long getAndAccumulate = atomicLong.getAndAccumulate(2, new LongBinaryOperator() {

            @Override
            public long applyAsLong(long left, long right) {
                return left / right;
            }
        });
        System.out.println(getAndAccumulate);
        System.out.println(atomicLong.get());
        LongAdder longAdder = new LongAdder();
        longAdder.increment();
        longAdder.reset();
        System.out.println(longAdder.sum());
        System.out.println(longAdder.longValue());
    }
}