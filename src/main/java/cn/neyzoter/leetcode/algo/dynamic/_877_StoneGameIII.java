package cn.neyzoter.leetcode.algo.dynamic;

/**
 * 877. 石子游戏
 * @author Charles Song
 * @date 2020-6-13
 */
public class _877_StoneGameIII {
    public static void main (String[] args) {
        int[] piles = {5,3,4,5};
        Sol_StoneGame sol = new Sol_StoneGame();
        System.out.println(sol.stoneGame(piles));
    }
}

class Sol_StoneGame {
    class Users {
        int first;
        int second;
        Users (int f, int s) {
            this.first = f;
            this.second = s;
        }
    }
    public boolean stoneGame(int[] piles) {
        Users[][] dp = new Users[piles.length][piles.length];
        for (int delta = 0; delta < piles.length; delta ++) {
            for (int i = 0, j = i + delta; j < piles.length; i ++, j = i + delta) {
                dp[i][j] = new Users(0, 0);
                if (i == j) {
                    dp[i][j].first = piles[i];
                    dp[i][j].second = 0;
                } else {
                    // 选择左边
                    int chooseLeft = piles[i] + dp[i + 1][j].second;
                    // 选择右边
                    int chooseRight = dp[i][j - 1].second + piles[j];
                    // 选择一个大的
                    dp[i][j].first = Math.max(chooseLeft, chooseRight);
                    // 根据first的选择来选择
                    dp[i][j].second = dp[i][j].first == chooseLeft ? dp[i + 1][j].first :
                            dp[i][j - 1].first;
                }
            }
        }
        int alex = dp[0][piles.length - 1].first;
        int lee = dp[0][piles.length - 1].second;
        return alex > lee;
    }

}