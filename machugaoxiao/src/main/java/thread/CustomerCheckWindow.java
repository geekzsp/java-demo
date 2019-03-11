package thread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangshipeng
 * 2018-12-28
 */
public class CustomerCheckWindow {
    public static void main(String[] args) {
        //设置3个信号量，即3个服务窗口
        Semaphore semaphore = new Semaphore(3);
        //有10个人需要进行安检
        for (int i = 0; i < 5; i++) {
            new SecurityCheckThread(i, semaphore).start();
        }
    }

    private static class SecurityCheckThread extends Thread {
        private int num;
        private Semaphore semaphore;

        public SecurityCheckThread(int num, Semaphore semaphore) {
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("No." + num + "乘客正在查验中");
                //假设号码为偶数的为可疑人员
                if (num % 2 == 0) {
                    TimeUnit.SECONDS.sleep(10);
                    System.out.println("No." + num + "身份可疑 仔细查验中");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                semaphore.release();
                System.out.println("No." + num + "乘客已完成服务。");
            }
        }
    }

}
