package thread;

import java.util.concurrent.*;

/**
 * @author zhangshipeng
 * 2018-12-28
 */
public class ThreadPoolDemo {
    public static void main(String[] args) {
        BlockingDeque<Runnable> queue = new LinkedBlockingDeque<>(2);
        UserThreadFactory userThreadFactory1 = new UserThreadFactory("杭州机房");
        UserThreadFactory userThreadFactory2 = new UserThreadFactory("北京机房");
        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, userThreadFactory1);
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1, 2, 60, TimeUnit.SECONDS, queue, userThreadFactory2, new UserRejectHandler());
        for (int i = 0; i < 400; i++) {
            try {
                threadPoolExecutor1.execute(() -> {
                    System.out.println("threadPoolExecutor1 running" + Thread.currentThread().getName());
                });
            } catch (Exception e) {
                System.out.println("捕获到了异常" + e.getMessage());
            }
            threadPoolExecutor2.execute(() -> {
                System.out.println("threadPoolExecutor2 running");
            });
        }
        ExecutorService executorService = Executors.newFixedThreadPool(1);
    }
}
