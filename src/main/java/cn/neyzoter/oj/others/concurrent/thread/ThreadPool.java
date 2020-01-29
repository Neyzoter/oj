package cn.neyzoter.oj.others.concurrent.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 线程池的测试
 * @author Neyzoter Song
 * @date 2020-1-29
 */
public class ThreadPool {
    private final static Logger logger = LoggerFactory.getLogger(ThreadPool.class);

    private BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque(10);
    /**
     * corePoolSize: 线程池的一直存在着的线程数量，如果线程个数超过这个数目，则需要创建新的线程
     * maximumPoolSize: 线程池最大线程数量
     * keepAliveTime: 如果要执行的任务多于线程池线程数，则一个空闲任务（没有任务执行）保持多久才会停止，直到线程个数等于corePoolSize
     * unit: 参数keepAliveTime的时间单位，TimeUnit.NANOSECONDS、TimeUnit.MICROSECONDS等
     * workQueue: 队列，用于保存等待执行的任务（可选择ArrayBlockingQueue、LinkedBlockingQueue、SynchronousQueue）
     * threadFactory: 线程工厂，用于创建线程
     * handler：表示当拒绝处理任务时的策略，以下是策略：
     *      ThreadPoolExecutor.AbortPolicy:丢弃任务并抛出RejectedExecutionException异常。
     *      ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
     *      ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     *      ThreadPoolExecutor.CallerRunsPolicy：由调用线程处理该任务
     */
    public ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2,9,100, TimeUnit.MICROSECONDS,workQueue);

    public static void main(String[] args) {
        ThreadPool threadPool = new ThreadPool();
        for (int i = 1; i < 20 ; i++) {
            try {
                threadPool.threadPoolExecutor.execute(new Task(i * 100000 * (int)Math.pow(-1,i)));
                logger.info(String.format("[i = %d] active count = %d , completed = %d",i,threadPool.threadPoolExecutor.getActiveCount(),threadPool.threadPoolExecutor.getCompletedTaskCount()));
            }catch (Exception e) {
                logger.error("",e);
            }

        }
    }
}

/**
 * 任务
 */
class Task implements Runnable{
    private final static Logger logger = LoggerFactory.getLogger(Task.class);
    int count;
    int maxcount;
    public Task(int cnt) {
        count = cnt;
        maxcount = cnt;
    }
    @Override
    public void run() {
        while (true) {
            if (count > 0) {
                count --;
            } else if (count < 0) {
                count ++;
            } else {
                logger.info(String.format("[Task(%d)] count dec to 0", maxcount));
                break;
            }
        }

    }
}
