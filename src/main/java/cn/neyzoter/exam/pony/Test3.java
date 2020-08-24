package cn.neyzoter.exam.pony;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        while(num -- > 0) {
            int n = sc.nextInt();
            int[] power = new int[4];
            for (int i = 0; i < 4; i++) {
                power[i] = sc.nextInt();
            }
            track(n, power);
        }
    }

    public static void track(int n, int[] power) {
        if (n == 0) {
            System.out.println(0);
            return;
        }
        long result = Long.MAX_VALUE;
        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[]{-1, power[2]});
        q.add(new long[]{1, power[3]});
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long[] vr = q.remove();
                if (vr[0] == n) {
                    result = Math.min(vr[1], result);
                } else {
                    if (vr[1] < result) {
                        q.add(new long[]{vr[0] * 3, vr[1] + power[0]});
                        q.add(new long[]{vr[0] * 2, vr[1] + power[1]});
                        q.add(new long[]{vr[0] - 1, vr[1] + power[2]});
                        q.add(new long[]{vr[0] + 1, vr[1] + power[3]});
                    }
                }
            }
        }
        System.out.println(result);
    }
}
