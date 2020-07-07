package cn.neyzoter.leetcode.algo.dynamic;

/**
 * 32. 最长有效括号
 * @author Charles Song
 * @date 2020-7-5
 */
public class _32_LongestValidParentheses {
    public static void main (String[] args) {

    }
}
class Sol1_32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        for (int i = 1; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
                continue;
            } else if (s.charAt(i - 1) == '(') {
                dp[i] = getDp(dp, i - 2) + 2;
            } else {
                if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = getDp(dp, i - 1) + 2 + getDp(dp, i - dp[i - 1] - 2);
                }
            }
            max = max > dp[i] ? max : dp[i];
        }
        return max;
    }

    public static int getDp(int[] dp, int i) {
        if (i < 0) {
            return 0;
        } else {
            return dp[i];
        }
    }
}