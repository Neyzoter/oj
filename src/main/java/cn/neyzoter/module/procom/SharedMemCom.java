package cn.neyzoter.module.procom;

import java.util.concurrent.Semaphore;

/**
 * 共享内存的进程间通信
 * @author Charles Song
 * @date 2020-4-26
 */
public class SharedMemCom {
    public static void main (String[] args) {
        for (int i = 0 ; i < 20; i ++) {
            new Task1().start();
            new Task2().start();
        }
    }
}

class SharedMem {
    private static int val = 0;
    private static final int SEMAPHORE_PERMITS_NUM = 1;
    private static Semaphore semaphore = new Semaphore(SEMAPHORE_PERMITS_NUM);

    public static int getVal() {
        try {
            System.out.println("availablePermits" + semaphore.availablePermits());
            // 阻塞或者直到线程挂起
            semaphore.acquire();
            // 注意：finnaly在return读取val后执行，但是还没有return
            return val;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (semaphore.availablePermits() < SEMAPHORE_PERMITS_NUM) {
                semaphore.release();
            }
        }
        return Integer.MIN_VALUE;
    }

    public static void setVal(int v) {
        try {
            System.out.println("availablePermits : " + semaphore.availablePermits());
            semaphore.acquire();
            // 如果是3的倍数则进行强制占用这个Semaphore
            //    以便看到效果
            if (v % 3 == 0) {
                Thread.sleep(200);
            }
            val = v;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            if (semaphore.availablePermits() < SEMAPHORE_PERMITS_NUM) {
                semaphore.release();
            }
        }
    }
}

class Task1 implements Runnable {
    @Override
    public void run () {
        int val = SharedMem.getVal();
        System.out.println(String.format("val = %d", val));
        int setVal = (int) (Math.random() * 100);
        SharedMem.setVal(setVal);
        System.out.println(String.format("set val = %d", setVal));
    }

    public void start () {
        Thread thread = new Thread(this, "Task1");
        thread.start();
    }
}

class Task2 implements Runnable {
    @Override
    public void run () {
        try {
            int val = SharedMem.getVal();
            System.out.println(String.format("val = %d (%d is err)", val, Integer.MIN_VALUE));
            val = SharedMem.getVal();
            System.out.println(String.format("val = %d (%d is err)", val, Integer.MIN_VALUE));
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void start () {
        Thread thread = new Thread(this, "Task2");
        thread.start();
    }
}
