package thread;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author zhangshipeng
 * 2018-12-25
 */
public class VoatileNotAtomic3 {
    private static LongAdder longAdder = new LongAdder();
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        SubtractThread subtractThread = new SubtractThread();
        subtractThread.start();
        for (int i = 0; i < NUMBER; i++) {
            longAdder.increment();

        }
        //等待减法线程结束
        while (subtractThread.isAlive()) {
        }
        System.out.println("count最后的值为：" + longAdder.intValue());
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                longAdder.decrement();
            }
        }
    }
}
