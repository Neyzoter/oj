package cn.neyzoter.sword;

import java.util.Scanner;

/**
 * 面试题14- I. 剪绳子  cuttingRope
 * @author Charles Song
 * @date 2020-3-24
 */
public class CuttingRope {
    public static void main (String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        String[] strings = str.split(" ");
        String[] strings ={"2", "3", "4","12", "10"};
        Solution1_CuttingRope solution1_cuttingRope = new Solution1_CuttingRope();
        for (String string : strings) {
            System.out.println(String.format("n = %s, max = %d", string, solution1_cuttingRope.cuttingRope(Integer.parseInt(string))));
        }
    }
}

/**
 * 动态规划
 */
class Solution1_CuttingRope {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;dp[1] = 1;
        // 前面的可以是将自己作为最长，因为肯定后面还有比他更大的，所以不会出现不裁剪的问题
        for (int len = 2 ; len < n; len ++) {
            dp[len] = len;
            for (int left = 2 , right = len - left; right > 1;left ++, right --) {
                if (dp[left] * dp[right] > dp[len]) {
                    dp[len] = dp[left] * dp[right];
                }
            }
        }
        // 最后一个必须要裁剪
        dp[n] = n - 1;
        for (int left = 2 , right = n - left; right > 1;left ++, right --) {
            if (dp[left] * dp[right] > dp[n]) {
                dp[n] = dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}