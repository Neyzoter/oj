package cn.neyzoter.exam.tencent;

import java.util.*;

/**
 * AC 80%
 * 数组越界
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        HashMap<Integer, Set<Integer>> hm = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < x; j++) {
                int per = sc.nextInt();
                set.add(per);
            }
            for (int p : set) {
                Set<Integer> origin = hm.getOrDefault(p, new HashSet<>());
                origin.addAll(set);
                hm.put(p, origin);
            }
        }
        System.out.println(dfs(0, new HashSet<>(), hm));
    }
    public static int dfs(int n, Set<Integer> arrived, HashMap<Integer, Set<Integer>> hm) {
        if (arrived.contains(n)) {
            return 0;
        }
        arrived.add(n);
        Set<Integer> next = hm.getOrDefault(n, new HashSet<>());
        int sum = 1;
        for (int tr : next) {
            sum += dfs(tr, arrived, hm);
        }
        return sum;
    }
}
