package cn.neyzoter.oj.dynamic;

/**
 * 62 不同路径
 */
public class UniquePath {
    public static void main(String[] args){
//        Solution1_UniquePath solution1_uniquePath = new Solution1_UniquePath();
//        System.out.println(solution1_uniquePath.uniquePaths(1,3));

        Solution2_UniquePath solution2_uniquePath = new Solution2_UniquePath();
        System.out.println(solution2_uniquePath.uniquePaths(7,3));
    }
}

/**
 * 递归法，会超时
 */
class Solution1_UniquePath {
    public static int cnt = 0;
    public int uniquePaths(int m, int n) {
        cnt = 0;
        if (m == 1 || n == 1) {
            cnt = 1;
            return cnt;
        }else {
            return pathCounter(m - 1,n - 1);
        }
    }
    private int pathCounter (int m, int n) {
        if (m > 0) {
            pathCounter(m - 1, n);
        }
        if (n > 0) {
            pathCounter(m, n - 1);
        }
        if (m == 0 && n == 0) {
            cnt ++;
        }
        return cnt;
    }
}

/**
 * 动态规划法
 */
class Solution2_UniquePath {
    public int uniquePaths(int m, int n) {
        if (m==1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        int i = m - 1;int j = n - 1;
        dp[i - 1][j] = 1;dp[i][j - 1] = 1;
        for (i = m - 1;i >= 0; i --) {
            for (j = n - 1;j >= 0; j --) {
                // 最后一行
                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                }else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}