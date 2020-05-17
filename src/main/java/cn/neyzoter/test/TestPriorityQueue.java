package cn.neyzoter.test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * 测试优先级队列
 * @author Charles Song
 * @date 2020-5-14
 */
public class TestPriorityQueue {
    public static void main (String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(1);queue.add(5);queue.add(3);
        // 按照大小顺序删除
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
        queue.remove();
        System.out.println(queue);
    }
}
