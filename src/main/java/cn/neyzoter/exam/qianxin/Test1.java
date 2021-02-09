package cn.neyzoter.exam.qianxin;

public class Test1 {
    public static void main(String[] args) {
        Dp dp = new Dp();
        int[][] matrix = new int[][]{{2, 3, 1}, {2, 5, 3}, {4, 2, 1}};
        long res = dp.trace(matrix);
        System.out.println(res);
    }
}

class Dp {
    public long trace(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        long[][] dp = new long[matrix.length][matrix[0].length];
        dp[0][0] = matrix[0][0];
        // 初始化第0列
        for (int i = 1; i < matrix.length; i++) {
            dp[i][0] = dp[i - 1][0] + matrix[i][0];
        }
        // 初始化第0行
        for (int i = 1; i < matrix[0].length; i++) {
            dp[0][i] = dp[0][i - 1] + matrix[0][i];
        }
        // 动态规划
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + matrix[i][j], dp[i][j - 1] + matrix[i][j]);
            }
        }
        // 返回最大结果
        return dp[matrix.length - 1][matrix[0].length - 1];
    }
}
