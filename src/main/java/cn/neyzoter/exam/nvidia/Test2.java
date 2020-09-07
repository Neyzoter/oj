package cn.neyzoter.exam.nvidia;

import scala.Int;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author neyzoter
 */
public class Test2 {
    public static final int MAX_VAL = 100001;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] sushu = new int[MAX_VAL];
        for (int i = 2; i < MAX_VAL; i++) {
            sushu[i] = i;
        }
        // 筛法
        for (int i = 2; i < MAX_VAL; i++) {
            if (sushu[i] != 0) {
                int j;
                for (j = 2 * i; j < MAX_VAL; j += i) {
                    sushu[j] = 0;
                }
            }
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        while (sc.hasNext()) {
            int sum = 0;
            int n = sc.nextInt();
            if (hm.containsKey(n)) {
                System.out.println(hm.get(n));
                continue;
            }
            for (int i = 2; i < n / 2; i++) {
                if (sushu[i] != 0) {
                    if (sushu[n - i] != 0) {
                        sum++;
                    }
                }
            }
            hm.put(n, sum);
            System.out.println(sum);
        }

    }
}
