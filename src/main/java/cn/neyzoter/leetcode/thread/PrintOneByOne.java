package cn.neyzoter.leetcode.thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1115. 交替打印FooBar
 * @author Charles Song
 * @date 2020-6-2
 */
public class PrintOneByOne {
    public static void main (String[] args) {
        FooBar fooBar = new FooBar(10);

    }
}

class FooBar {
    private int n;
    private AtomicInteger fooNum;
    private AtomicInteger barNum;
    private final Object lock;

    public FooBar(int n) {
        this.n = n;
        lock = new Object();
        fooNum = new AtomicInteger(0);
        barNum = new AtomicInteger(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (fooNum.get() > barNum.get()) {
                    lock.wait();
                }
                // printFoo.run() outputs "foo". Do not change or remove this line.
                printFoo.run();
                fooNum.incrementAndGet();
                lock.notifyAll();
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            synchronized (lock) {
                while (fooNum.get() == barNum.get()) {
                    lock.wait();
                }
                // printBar.run() outputs "bar". Do not change or remove this line.
                printBar.run();
                barNum.incrementAndGet();
                lock.notifyAll();
            }

        }
    }
}