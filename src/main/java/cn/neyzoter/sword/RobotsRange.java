package cn.neyzoter.sword;

/**
 * 机器人运动范围
 * @author Charles Song
 * @date 2020-5-22
 */
public class RobotsRange {
    public static void main (String[] args) {
        Solution1_RobotsRange robotsRange = new Solution1_RobotsRange();
        int m = 3, n = 2, k = 17;
        System.out.println(robotsRange.movingCount(m, n, k));
    }

}

class Solution1_RobotsRange {
    public int movingCount(int m, int n, int k) {
        int i = 0, j = 0;
        boolean[][] arrived = new boolean[m][n];
        return dfs(i, j, m, n, k, arrived);
    }

    public int dfs (int i, int j, int m, int n, int k, boolean[][] arrived) {
        int sum = getSum(i) + getSum(j);
        boolean canArrive = sum <= k && i < m && j < n;
        if (!canArrive) {
            return 0;
        }
        if (arrived[i][j]) {
            return 0;
        }
        arrived[i][j] = true;
        int count = 1;
        count += dfs(i + 1, j, m, n, k, arrived);
        count += dfs(i, j + 1, m, n, k, arrived);
        return count;
    }

    public static int getSum (int num) {
        int sum = 0;
        for (;num > 0;) {
            sum += num % 10;
            num = num / 10;
        }
        return sum;
    }
}