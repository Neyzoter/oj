package cn.neyzoter.exam.pony;

import java.util.*;

/**
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> up = new HashMap<>();
        Set<Integer> special = new HashSet<>();
        int root = 0;
        for (int i = 1; i <= n; i++) {
            int father = sc.nextInt();
            int val = sc.nextInt();
            if (father != -1) {
                up.put(i, father);
            } else {
                root = i;
            }
            if (val == 1) {
                special.add(i);
            }
        }
        boolean[] sepc = new boolean[n + 1];
        for (int i : special) {
            sepc[i] = true;
            if (i == root) {
                continue;
            }
            int temp = i;
            do {
                temp = up.get(temp);
                sepc[temp] = true;
            } while (up.containsKey(temp));
        }
        boolean first = true;
        for (int i = 1; i <= n; i++) {
            if (!sepc[i]) {
                if (first) {
                    System.out.print(i);
                    first = false;
                } else {
                    System.out.print(" " + i);
                }
            }
        }
    }
}
