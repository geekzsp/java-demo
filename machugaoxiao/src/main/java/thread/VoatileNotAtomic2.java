package thread;

/**
 * @author zhangshipeng
 * 2018-12-25
 */
public class VoatileNotAtomic2 {
    private static volatile long count = 0L;
    private static final int NUMBER = 10000;

    public static void main(String[] args) {
        SubtractThread subtractThread = new SubtractThread();
        subtractThread.start();
        for (int i = 0; i < NUMBER; i++) {
            synchronized (VoatileNotAtomic2.class) {
                count++;
            }

        }
        //等待减法线程结束
        while (subtractThread.isAlive()) {
        }
        System.out.println("count最后的值为：" + count);
    }

    private static class SubtractThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < NUMBER; i++) {
                synchronized (VoatileNotAtomic2.class) {
                    count--;
                }
            }
        }
    }
}
