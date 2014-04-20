package ua.alf;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: Eugene Chipachenko
 * Date: 20.04.2014
 * Time: 13:48
 */
public class ThreadPoolManager {
    private static ThreadPoolManager ourInstance = new ThreadPoolManager();

    public static ThreadPoolManager getInstance() {
        return ourInstance;
    }

    private ScheduledThreadPoolExecutor scheduledExecutor = new ScheduledThreadPoolExecutor(2);

    private ThreadPoolManager() {
    }

    public Future scheduleAtFixedRate(Runnable runnable, long init, long delay, TimeUnit timeUnit) {
        return scheduledExecutor.scheduleAtFixedRate(runnable, init, delay, timeUnit);
    }

    public void shutdown() throws InterruptedException {
        scheduledExecutor.purge();
        scheduledExecutor.shutdown();
        scheduledExecutor.awaitTermination(1, TimeUnit.SECONDS);
    }

}
