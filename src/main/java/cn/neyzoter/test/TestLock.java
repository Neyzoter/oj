package cn.neyzoter.test;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

/**
 * 测试锁
 * @author Charles Song
 * @date 2020-4-21
 */
public class TestLock {
    public static final ReentrantLock lock = new ReentrantLock();
    public static final Condition condition = lock.newCondition();
    public static void main (String[] args) {
        Task1 task1 = new Task1(condition, lock);
        Task2 task2 = new Task2(condition, lock);
        task1.start();
        task2.start();

    }
}

class Task1 implements Runnable {
    public Condition condition;
    public final Lock lock;

    Task1 (Condition cond, Lock lock) {
        this.condition = cond;
        this.lock = lock;
    }
    @Override
    public void run () {
        lock.lock();
        try {
            System.out.println("task1 waiting for signal...");
            TestLock.condition.await();
            System.out.println("task1 ran...");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }

    }
    public void start () {
        Thread thread = new Thread(this, "Task1");
        thread.start();
    }
}

class Task2 implements Runnable {
    public Condition condition;
    public final Lock lock;

    Task2 (Condition cond, Lock lock) {
        this.condition = cond;
        this.lock = lock;
    }
    @Override
    public void run () {
        lock.lock();
        try {
            sleep(5000);
            System.out.println("task2 ran...");
            System.out.println("task2 send signal...");
            TestLock.condition.signal();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }

    public void start () {
        Thread thread = new Thread(this, "Task2");
        thread.start();
    }
}