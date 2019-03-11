package thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhangshipeng
 * 2018-12-25
 */
public class CountDownLatchTest {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            System.out.println("捕获到了异常信息");
            countDownLatch.countDown();

        });
        try {
            TranslateThread translateThread1 = new TranslateThread("conent 1", countDownLatch);
            TranslateThread translateThread2 = new TranslateThread("conent 2", countDownLatch);
            TranslateThread translateThread3 = new TranslateThread("conent 3", countDownLatch);
            translateThread1.start();
            translateThread2.start();
            translateThread3.start();
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("所有线程执行完成");
    }
    static class TranslateThread extends Thread {
        private String content;
        private final CountDownLatch countDownLatch;

        TranslateThread(String content, CountDownLatch countDownLatch) {
            this.content = content;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {
            if (Math.random() > 0.5) {
                throw new RuntimeException("原文存在非法字符");
            }
            System.out.println(content + "的译文翻译完成");
            countDownLatch.countDown();
        }

    }
}
