package cn.neyzoter.exam.vivo.advance;

import java.util.HashMap;
import java.util.Scanner;


/**
 * 扔鸡蛋问题
 * @author Charles Song
 * @date 2020-6-7
 */
public class Test2 {
    private static HashMap<String, Integer> map = new HashMap<>();
    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(drop(a, b));
        }
    }

    public static int drop (int K,int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        String key = getKey(K, N);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = N;
        int left = 1, right = N;
        while (left <= right) {
            int mid = (left + right) / 2;
            int broken = drop(K - 1, mid - 1);
            int notBroken = drop(K,N - mid);
            if (broken > notBroken) {
                res = Math.min(res, broken + 1);
                right = mid - 1;
            } else {
                res = Math.min(res, notBroken + 1);
                left = mid + 1;
            }
        }
        map.put(key, res);
        return res;
    }

    public static String getKey (int K,int N) {
        return String.format("%d_%d", K, N);
    }
}
