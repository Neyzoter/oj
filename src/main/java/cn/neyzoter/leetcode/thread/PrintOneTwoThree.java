package cn.neyzoter.leetcode.thread;

import javafx.beans.binding.ObjectExpression;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1114. 按序打印
 */
public class PrintOneTwoThree {
    public static void main (String[] args) {

    }
}

class Foo {
    private Object lock;

    private volatile boolean firstOk;
    private volatile boolean secondOk;

    public Foo() {
        lock = new Object();
        firstOk = false;
        secondOk = false;
    }
    public void first(Runnable printFirst) throws InterruptedException {
        synchronized (lock) {
            printFirst.run();
            firstOk = true;
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        synchronized (lock) {
            while (!firstOk){
                lock.wait();
            }
            printSecond.run();
            secondOk = true;
            lock.notifyAll();
        }

    }

    public void third(Runnable printThird) throws InterruptedException {
        synchronized (lock) {
            while (!secondOk){
                lock.wait();
            }
            printThird.run();
        }
    }
}
