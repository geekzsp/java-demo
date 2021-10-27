package xyz.mosss.spring.examples.springboot.a.d;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Tset {
    public static void main(String[] args) {
        //System.out.println("123");
        //System.out.println(Bean1.a);
        //System.out.println(Bean2.b);
        AtomicLong atomicLong = new AtomicLong();
        System.out.println(atomicLong.incrementAndGet());
        System.out.println(atomicLong.incrementAndGet());
        //LongAdder longAdder = new LongAdder();

        atomicLong.compareAndSet(12,13);
    }
}