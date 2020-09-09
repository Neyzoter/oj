package cn.neyzoter.exam.glodan;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 测试3
 * 我们希望一个序列中的元素是各不相同的，但是理想和现实往往是有差距的。现在给出一个序列A，其中难免有些相同的元素，现在提供了一种变化方式，使得经过若干次操作后一定可以得到一个元素各不相同的序列。
 *
 * 这个操作是这样的，令x为序列中最小的有重复的数字，你需要删除序列左数第一个x，并把第二个x替换为2*x。
 *
 * 请你输出最终的序列。
 *
 * 例如原序列是[2,2,1,1,1],一次变换后变为[2,2,2,1]，两次变换后变为[4,2,1]，变换结束
 *
 *
 *
 * 输入描述
 * 输入第一行包含一个正整数n，表示序列的长度为n。(1<=n<=50000)
 *
 * 第二行有n个整数，初始序列中的元素。(1<=a_i<=10^8)
 *
 * 输出描述
 * 输出包含若干个整数，即最终变换之后的结果。
 *
 *
 * 样例输入
 * 5
 * 5 5 5 5 4
 * 样例输出
 * 20 4
 * @author neyzoter
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {return o1[0] - o2[0] == 0 ? o1[1] - o2[1] : o1[0] - o2[0];});
        for (int i = 0; i < n; i++) {
            int[] valIdx = new int[2];
            valIdx[0] = sc.nextInt();
            valIdx[1] = i;
            pq.add(valIdx);
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = -1;
        }
        int num = 0;
        while (pq.size() > 1) {
            int[] valIdx1 = pq.poll();
            int[] valIdx2 = pq.poll();
            if (valIdx1[0] != valIdx2[0]) {
                arr[valIdx1[1]] = valIdx1[0];
                num++;
                pq.add(valIdx2);
            } else {
                valIdx2[0] *= 2;
                pq.add(valIdx2);
            }
        }
        if (pq.size() == 1) {
            int[] valIdx = pq.poll();
            arr[valIdx[1]] = valIdx[0];
            num++;
        }
        for (int val : arr) {
            if (val != -1) {
                System.out.print(val);
                if (num > 1) {
                    System.out.print(" ");
                }
                num--;
            }
        }
    }
}
