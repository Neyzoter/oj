package cn.neyzoter.module.concurrent.thread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * test cyclic barries test
 * @author Neyzoter Song
 * @date 2020-2-18
 */
public class CyclicBarrierTest {
    public static int ThreadNum = 5;
    public static CyclicBarrier cyclicBarrier = new CyclicBarrier(ThreadNum,new CyclicBarrierRunnable());
    public static void main (String[] args) {
        for (int i = 0; i < ThreadNum ;i ++ ){
            try{
                Thread.sleep(50);
                new CyclicBarrierTask(cyclicBarrier,i).start();
            } catch (Exception e) {
                System.out.println(e);
            }

        }
    }


}

class CyclicBarrierTask extends Thread {
    public CyclicBarrier cyclicBarrier;
    public int threadId;
    public CyclicBarrierTask(CyclicBarrier cyclicBarrier, int id) {
        this.cyclicBarrier = cyclicBarrier;
        this.threadId = id;
    }
    @Override
    public void run() {
        try{
            Thread.sleep(100);
            System.out.println(String.format("[%d]Task[%d] Over, Wait for all tasks over!", System.currentTimeMillis(),this.threadId));
            this.cyclicBarrier.await(10, TimeUnit.SECONDS);
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            System.out.println(String.format("Task[%d] exited!", this.threadId));
        }
    }
}

class CyclicBarrierRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Tasks Over!");
    }
}