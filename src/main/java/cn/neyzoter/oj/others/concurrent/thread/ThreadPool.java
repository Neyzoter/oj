package cn.neyzoter.oj.others.concurrent.thread;

import java.util.concurrent.*;

/**
 * 线程池的测试
 * @author Neyzoter Song
 * @date 2020-1-29
 */
public class ThreadPool {
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
    public ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(8,20,100, TimeUnit.MICROSECONDS,workQueue);
}
