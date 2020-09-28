package cn.neyzoter.exam.qihu360;

import com.sun.mail.imap.protocol.BODY;
import javafx.util.Pair;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 5 6 1 5
 * 1 5 100
 * 1 2 10
 * 2 5 5
 * 1 3 3
 * 3 4 2
 * 4 5 1
 *
 * 3
 * @author neyzoter
 */
public class Test2 {
    public static HashMap<Integer, Set<Integer>> sourceDest;
    public static HashMap<String, Long> power;
    public static HashMap<Integer, Long> min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt(),
                s = sc.nextInt(), t = sc.nextInt();
        sourceDest = new HashMap<>();
        power = new HashMap<>();
        min = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt(), v = sc.nextInt(), w = sc.nextInt();
            String sd = getSd(u, v);
            power.put(sd, (long) w);
            sd = getSd(v, u);
            power.put(sd, (long) w);
            Set<Integer> hs1 = sourceDest.getOrDefault(u, new HashSet<>());
            hs1.add(v);
            sourceDest.put(u, hs1);
            Set<Integer> hs2 = sourceDest.getOrDefault(v, new HashSet<>());
            hs2.add(u);
            sourceDest.put(v, hs2);
        }
        System.out.println(dfs(new HashSet<>(), s, t));
    }

    public static long dfs(Set<Integer> arrived, int s, int t) {
        if (s == t) {
            return 0;
        }
        if (min.containsKey(s)) {
            return min.get(s);
        }
        long minPath = Long.MAX_VALUE;
        Set<Integer> next = sourceDest.get(s);
        for (int n : next) {
            if (arrived.contains(n)) {
                continue;
            }
            arrived.add(n);
            minPath = Math.min(dfs(arrived, n, t) + power.get(getSd(s, n)), minPath);
            arrived.remove(n);
        }
        min.put(s, minPath);
        return minPath;
    }

    public static String getSd(int s, int t) {
        return String.format("%d_%d", s, t);
    }
}
