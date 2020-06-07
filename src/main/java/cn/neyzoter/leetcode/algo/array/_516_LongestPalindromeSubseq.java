package cn.neyzoter.leetcode.algo.array;

/**
 * 516. 最长回文子序列
 * @author Charles Song
 * @date 2020-6-7
 */
public class _516_LongestPalindromeSubseq {
    public static void main (String[] args) {
        String str = "cbbd";
        Sol1_LongestPalindromeSubseq sol = new Sol1_LongestPalindromeSubseq();
        System.out.println(sol.longestPalindromeSubseq(str));
    }
}

class Sol1_LongestPalindromeSubseq {
    public int longestPalindromeSubseq(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i ++) {
            dp[i][i] = 1;
        }

        for (int delta = 1; delta < s.length(); delta ++) {
            for (int i = 0, j = i + delta; j < s.length(); i ++, j++ ) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i + 1][j - 1];
                } else {
                    dp[i][j] = max(dp[i + 1][j - 1], dp[i][j - 1], dp[i + 1][j]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static int max (int a1, int a2, int a3) {
        int temp = a1 > a2 ? a1 : a2;
        temp = temp > a3 ? temp : a3;
        return temp;
    }
}
