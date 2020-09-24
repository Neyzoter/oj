package cn.neyzoter.exam.meituan;

/**
 * 最长公共子序列
 */
public class Intv {
    public static void main(String[] args) {
        String s1 = "1A2C3D4B56";
        String s2 = "B1D23CA45B6A";
        // 输出123456
        Intv intv = new Intv();
        System.out.println(intv.LCS(s1, s2));
    }
    public String LCS (String s1, String s2) {
        String[][] dp = new String[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = "";
        }
        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = "";
        }
        for (int i = 1; i < s1.length() + 1; i++) {
            for (int j = 1; j < s2.length() + 1; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = dp[i - 1][j].length() > dp[i][j - 1].length() ? dp[i - 1][j] : dp[i][j - 1];
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
}
