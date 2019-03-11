package thread;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangshipeng
 * 2018-12-28
 */
public class UserThreadFactory implements ThreadFactory {
    private final String namePrefix;
    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    public UserThreadFactory(String whatFeatureOfGroup) {
        namePrefix = "UserThreadFactory" + whatFeatureOfGroup;
    }

    @Override
    public Thread newThread(Runnable r) {
        String name = namePrefix + "-worker-" + atomicInteger.getAndIncrement();
        Thread thread = new Thread(null, r, name, 0);
        System.out.println(thread.getName());
        return thread;
    }
}
