package cn.neyzoter.module.eat;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 哲学家进餐问题
 * @author Charles Song
 * @date 2020-6-11
 */
public class SemaphoreEat {
    public static Semaphore[] semaphore = new Semaphore[5];
    public static void main (String[] args) {
        for (int i = 0; i < semaphore.length; i ++) {
            semaphore[i] = new Semaphore(1);
        }
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.MICROSECONDS, new ArrayBlockingQueue<>(5));
        Eater e1 = new Eater(0, semaphore);
        Eater e2 = new Eater(1, semaphore);
        Eater e3 = new Eater(2, semaphore);
        Eater e4 = new Eater(3, semaphore);
        Eater e5 = new Eater(4, semaphore);
        executor.submit(e1);executor.submit(e2);executor.submit(e3);executor.submit(e4);executor.submit(e5);
    }

}

class Eater implements Runnable {
    public int id;
    public Semaphore[] fork;
    public Eater (int id, Semaphore[] fork) {
        this.id = id;
        this.fork = fork;
    }
    @Override
    public void run () {
        eat(fork);
    }

    public void eat (Semaphore[] fork) {
        if (this.id % 2 == 0) {
            try {

                // 获取信号量，等待，直到可以获取
                // 右侧叉子
                int forkid1 = (this.id + 1) % fork.length;
                fork[forkid1].acquire();
                print(id, forkid1);
                Thread.sleep(100);
                // 获取信号量，等待，直到可以获取
                // 左侧叉子
                int forkid2 = (this.id + fork.length - 1) % fork.length;
                fork[forkid2].acquire();
                print(id, forkid2);
                System.out.println(String.format("Eater[%d] is Eating", id));
                Thread.sleep(100);
                fork[forkid1].release();
                fork[forkid2].release();
                System.out.println(String.format("Eater[%d] quit", id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                // 获取信号量，等待，直到可以获取
                // 左侧叉子
                int forkid1 = (this.id + fork.length - 1) % fork.length;
                fork[forkid1].acquire();
                print(id, forkid1);
                Thread.sleep(100);
                // 获取信号量，等待，直到可以获取
                // 右侧叉子
                int forkid2 = (this.id + 1) % fork.length;
                fork[forkid2].acquire();
                print(id, forkid2);

                System.out.println(String.format("Eater[%d] is Eating", id));
                Thread.sleep(100);
                fork[forkid1].release();
                fork[forkid2].release();
                System.out.println(String.format("Eater[%d] quit", id));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
    public static void print (int id, int fork) {
        System.out.println(String.format("Eater[%d] has kept fork[%d]", id, fork));
    }
}
