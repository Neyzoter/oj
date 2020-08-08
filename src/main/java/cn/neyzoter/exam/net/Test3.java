package cn.neyzoter.exam.net;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Test3
 * <pre>
 * 1
 * 5
 * 30 60 5 15 30
 * </pre>
 *
 * 输出：20
 */

public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            long removedSum = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            long sum = sum(nums);
            for (int i = 0; i <= nums.length; i++) {
                List<boolean[]> list = new ArrayList<>();
                boolean[] removed = new boolean[nums.length];
                getRemoved(removed,0, list, i);
                for (boolean[] r : list) {
                    if (canPartition(nums, r)) {
                        long res = sum(nums, r);
                        long resVert = sum - res;
                        removedSum = removedSum > resVert ? resVert : removedSum;
                    }
                }
            }
            t--;
            System.out.println(removedSum);
        }
    }
    public static void getRemoved(boolean[] removed, int start, List<boolean[]> list, int n) {
        if (n == 0) {
            list.add(removed.clone());
        }
        for (int i = start; i < removed.length; i++) {
            if (!removed[i]) {
                removed[i] = true;
                getRemoved(removed, start + 1, list, n - 1);
                removed[i] = false;
            }
        }
    }
    public static boolean canPartition(int[] nums, boolean[] removed) {
        if (nums.length == 0) {
            return true;
        }
        int sum = sum(nums, removed);
        if (sum % 2 != 0) {
            return false;
        }
        int half = sum / 2;

        boolean[] dp = new boolean[half + 1];
        dp[0] = true;
        for (int i = 1; i < nums.length + 1; i ++) {
            if (removed[i - 1]) {
                continue;
            }
            // 注意j从half开始，防止一个数字被使用多次
            for (int j = half; j > 0; j --) {
                if (dp[j]) {
                    break;
                }
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[half];
    }
    public static int sum (int[] nums, boolean[] removed) {
        int sum = 0;
        for (int i = 0; i < removed.length; i ++) {
            if (!removed[i]) {
                sum += nums[i];
            }
        }
        return sum;
    }
    public static int sum (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
