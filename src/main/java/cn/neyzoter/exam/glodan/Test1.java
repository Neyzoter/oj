package cn.neyzoter.exam.glodan;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 测试1
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int x = sc.nextInt();
        if (n == 0) {
            System.out.print(0);
            return;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(sc.nextInt());
        }
        while (m-- > 0) {
            int min = pq.poll();
            pq.add(min + x);
        }
        System.out.print(pq.peek());
    }
}
