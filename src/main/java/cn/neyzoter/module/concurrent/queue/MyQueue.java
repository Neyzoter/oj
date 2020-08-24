package cn.neyzoter.module.concurrent.queue;

import java.util.concurrent.Semaphore;

/**
 * 自定义Queue<br>
 * 拼多多面试题
 */
public class MyQueue<T> {
    Semaphore mutex;
    Semaphore empty;
    Semaphore full;
    Object[] table;
    int head;
    int tail;
    final int capability;
    public MyQueue(int cap) {
        table =  new Object[cap];
        empty = new Semaphore(cap);
        try {
            // 先清空
            empty.acquire(cap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        full = new Semaphore(cap);
        mutex = new Semaphore(1);
        head = 0;
        tail = 0;
        capability = cap;
    }

    public T pop() throws Exception{
        // empty - 1
        boolean acq = empty.tryAcquire();
        // 如果没有成功获取
        if (!acq) {
            throw new Exception("Empty!");
        }
        // mutex - 1
        mutex.acquire();
        @SuppressWarnings("unchecked")
        T r = (T) table[head];
        head = (head + 1) % capability;
        // mutex + 1
        mutex.release();
        // full + 1
        full.release();
        System.out.println("poped " + r);
        return r;
    }

    public void push(T t) throws Exception {
        boolean push = full.tryAcquire();
        if (!push) {
            throw new Exception("Full!");
        }
        mutex.acquire();
        table[tail] = t;
        tail = (tail + 1) % capability;
        mutex.release();
        empty.release();
        System.out.println("pushed " + t);
    }
}
