package cn.neyzoter.module.concurrent.queue;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 自定义Queue<br>
 * 拼多多面试题
 */
public class MyQueueByLock<T> {
    Object[] table;
    int head;
    int tail;
    final int capability;
    int size;
    ReentrantLock lock;
    public MyQueueByLock(int cap) {
        table =  new Object[cap];
        head = 0;
        tail = 0;
        capability = cap;
        lock = new ReentrantLock();
    }

    public T pop() throws Exception{
        if (size > 0) {
            lock.lock();
            @SuppressWarnings("unchecked")
            T r = (T) table[head];
            head = (head + 1) % capability;
            size--;
            System.out.println("poped " + r);
            lock.unlock();
            return r;
        }
        throw new Exception("Empty!");
    }

    public void push(T t) throws Exception {
        if (size < capability) {
            lock.lock();
            table[tail] = t;
            tail = (tail + 1) % capability;
            size++;
            System.out.println("pushed " + t);
            lock.unlock();
            return;
        }
        throw new Exception("Full!");
    }
}
