package cn.neyzoter.leetcode.algo.array;

/**
 * 1143. 最长公共子序列
 * @author Charles Song
 * @date 2020-6-7
 */
public class _1143_LongestCommonSubsequence {
    public static void main (String[] args) {
        Sol1_LongestCommonSubsequence sol = new Sol1_LongestCommonSubsequence();
        String[] s1 = {"abcde", "abc", "abc", ""};
        String[] s2 = {"ace", "abc", "def", ""};
        for (int i = 0; i < s1.length; i ++) {
            System.out.println(sol.longestCommonSubsequence(s1[i], s2[i]));
        }

    }
}

class Sol1_LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i < text1.length() + 1; i ++) {
            for (int j = 1; j < text2.length() + 1; j ++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
