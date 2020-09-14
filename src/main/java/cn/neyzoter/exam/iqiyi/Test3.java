package cn.neyzoter.exam.iqiyi;

import java.util.*;

/**
 * @author neyzoter
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strVal = sc.nextLine().split(" ");
        int[] val = new int[strVal.length];
        for (int i = 0 ; i < val.length; i++) {
            val[i] = Integer.parseInt(strVal[i]);
        }
        int n = val.length;
        Arrays.sort(val);
        List<List<Integer>> ans = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && val[i] == val[i - 1]) {
                continue;
            }
            int k = n - 1;
            int target = -val[i];
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && val[j] == val[j - 1]) {
                    continue;
                }
                while (j < k && val[j] + val[k] > target) {
                    k--;
                }
                if (j == k) {
                    break;
                }
                if (val[j] + val[k] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(val[i]);
                    list.add(val[j]);
                    list.add(val[k]);
                    ans.add(list);
                }
            }
        }
        for (List<Integer> l : ans) {
            System.out.println(String.format("%s %s %s", l.get(0), l.get(1), l.get(2)));
        }

    }
}
