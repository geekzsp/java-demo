package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zhangshipeng
 * 2018-12-25
 */
public class VoatileNotAtomic4 {


    private static volatile long count = 0L;
    private static final int NUMBER = 1;
    public static void main(String[] args) throws InterruptedException {
        for (int i=0 ;i<100;i++) {
            CountDownLatch countDownLatch = new CountDownLatch(1);
            SubtractThread subtractThread = new SubtractThread(countDownLatch);
            subtractThread.start();
            SubtractThread subtractThread2 = new SubtractThread(countDownLatch);
            subtractThread2.start();
            //Thread.sleep(1000);
            countDownLatch.countDown();
            //System.out.println("线程统一放行");
            while (subtractThread.isAlive()&&subtractThread2.isAlive()){

            }
            System.out.println("count最后的值为：" + count);
            count=0;
        }
    }

    private static class SubtractThread extends Thread {
        private  final CountDownLatch countDownLatch;


        public SubtractThread(CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                try {
                    //System.out.println("线程等待中");
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count--;
            }
        }
    }
}
