package cn.neyzoter.module.concurrent.thread;

import java.util.concurrent.CountDownLatch;

/**
 * 测试CountDownLatch类<br/>
 * 一个线程等待其他线程执行 l.countDown(); 。阻塞的是单个进程。
 * @author Chales Song
 * @date 2020-5-1
 */
public class CountDownLatchTest {
    public static void main (String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(4);
        new WaitingTask(countDownLatch).start();
        for (int i = 0; i < 4 ; i ++) {
            new CountTask(countDownLatch).start();
        }
    }
}

/**
 * 等待计数到达
 * @author Charles Song
 * @date 2020-5-1
 */
class WaitingTask implements Runnable {
    CountDownLatch countDownLatch;
    WaitingTask (CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run () {
        try {
            System.out.println("WaitingTask is waiting!");
            this.countDownLatch.await();
            System.out.println("WaitingTask quited off waiting!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void start () {
        new Thread(this).start();
    }
}

/**
 * count任务
 * @author Charles Song
 * @date 2020-5-1
 */
class CountTask implements Runnable {
    CountDownLatch countDownLatch;
    CountTask (CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }
    @Override
    public void run () {
        try {
            System.out.println("CountTask is running!");
            this.countDownLatch.countDown();
            System.out.println("Count is " + this.countDownLatch.getCount());
            System.out.println("CountTask finished!");
        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void start () {
        new Thread(this).start();
    }
}