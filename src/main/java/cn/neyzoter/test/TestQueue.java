package cn.neyzoter.test;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 测试队列
 * @author Charles Song
 * @date 2020-5-5
 */
public class TestQueue {
    public static void main (String[] args) {
        Queue<Integer> queue = new ArrayDeque<>(10);
        queue.add(1);queue.add(3);queue.add(5);queue.add(10);queue.add(7);
        /**
         * （1）添加方法
         * boolean add(E e);  加入到队列，且可能抛出容量不够的异常
         * boolean offer(E e);   加入到队列，不抛出容量不够的异常（返回false）
         * （2）移除方法
         * E remove();  获取并移除第一个元素（不同于Collection接口的boolean remove(Object o)），如果空，则抛出异常；非空，则返回删除的元素
         * E poll();   获取并除第一个元素，如果空，则返回null；非空，则返回删除的元素
         * （3）获取方法
         * E element();   获取第一个元素，如果空，则抛出异常；非空，则返回元素
         * E peek();     获取第一个元素，如果空，则返回null；非空，则返回元素
         */
        // 获取第一个元素，且不删除，空则抛出异常
        System.out.println(queue.element());
        // 获取第一个元素，删除
        System.out.println(queue.poll());
        // 获取第一个元素，删除，空抛出异常
        System.out.println(queue.remove());
        // 获取第一个元素，不删除，不抛出异常
        System.out.println(queue.peek());
    }
}
