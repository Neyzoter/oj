package cn.neyzoter.exam.hulu4ZZH;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;

/**
 * AC 55%
 *HashMap hm
 *
 * dfs(int[] nums, int start, int end) {
 * 	if start == end
 * 		return 1
 * 	if hm.contains([start, end])
 * 		return hm.get([start, end])
 * 	for i = start : end
 * 		num = nums[i]
 * 		if num == num[i - 1]
 * 			continue
 * 		else
 * 			int left = dfs(nums, start, i)
 * 			int right = dfs(nums, i + 1, end)
 * 			hm.put([start, i], left)
 * 			hm.put([i + 1, end], right)
 * 			return left + right
 * }
 */
public class Test1 {
    public static HashMap<Pair<Integer, Integer>, Long> hm = new HashMap<>();
    public static void main(String[] args) {
        System.out.println(dfs(new int[]{1, 1, 2, 2}, 0, 4));

        int[] pair1 = new int[]{1,2};
        int[] pair2 = new int[]{1,2};
        System.out.println("pair1.equals(pair2) : " + pair1.equals(pair2));
    }
    public static long dfs(int[] nums, int start, int end) {
        if (start == end) {
            return 1;
        }
        Pair<Integer, Integer> pair = new Pair<>(start, end);
        if (hm.containsKey(pair)) {
            return hm.get(pair);
        }
        long res = 0;
        for (int i = start; i < end; i++) {
            int n = nums[i];
            if (i > start && n == nums[i - 1]) {
                continue;
            } else {
                long left = dfs(nums, start, i);
                long right = dfs(nums, i + 1, end);
                hm.put(new Pair<>(start, i), left);
                hm.put(new Pair<>(i + 1, end), right);
                res += left * right % 10000007;
            }
        }
        return res % 10000007;
    }
}
