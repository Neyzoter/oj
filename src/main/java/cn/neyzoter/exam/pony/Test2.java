package cn.neyzoter.exam.pony;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Test2 {
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
        HashMap<Long, Long> arrived = new HashMap<>();
        long result = Long.MAX_VALUE;
        Queue<long[]> q = new ArrayDeque<>();
        q.add(new long[]{-1, power[2]});
        q.add(new long[]{1, power[3]});
        arrived.put((long)-1, (long)power[2]);
        arrived.put((long)1, (long)power[3]);
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long[] vr = q.remove();
                if (vr[0] == n) {
                    result = Math.min(vr[1], result);
                } else {
                    if (vr[1] < result) {
                        long mult3 = vr[0] * 3;
                        long p = vr[1] + power[0];
                        if (mult3 < n * 3 && arrived.getOrDefault(mult3, Long.MAX_VALUE) > p) {
                            arrived.put(mult3, p);
                            q.add(new long[]{mult3, p});
                        }
                        long mult2 = vr[0] * 2;
                        p = vr[1] + power[1];
                        if (mult2 < n * 3 && arrived.getOrDefault(mult2, Long.MAX_VALUE) > p) {
                            arrived.put(mult2, p);
                            q.add(new long[]{mult2, p});
                        }
                        long add_1 = vr[0] - 1;
                        p = vr[1] + power[2];
                        if (add_1 < n * 3 && arrived.getOrDefault(add_1, Long.MAX_VALUE) > p) {
                            arrived.put(add_1, p);
                            q.add(new long[]{add_1, p});
                        }
                        long addp1 = vr[0] + 1;
                        p = vr[1] + power[3];
                        if (addp1 < n * 3 && arrived.getOrDefault(addp1, Long.MAX_VALUE) > p) {
                            arrived.put(addp1, p);
                            q.add(new long[]{addp1, p});
                        }
                    }
                }
            }
        }
        System.out.println(result);
    }
}
