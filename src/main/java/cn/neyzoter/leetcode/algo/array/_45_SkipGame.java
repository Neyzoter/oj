package cn.neyzoter.leetcode.algo.array;

/**
 * 45 跳跃游戏
 * @author neyzoter
 */
public class _45_SkipGame {
    public static void main(String[] args) {

    }
}

/**
 * 贪心算法
 */
class Sol1_45_SkipGame {
    public int jump(int[] nums) {
        int max = 0;
        int skip = 0;
        int nextIdx = 0;
        for (int i = 0; i < nums.length - 1;i++) {
            int rmtPos = nums[i] + i;
            max = Math.max(rmtPos, max);
            if (i == nextIdx) {
                nextIdx = max;
                skip++;
            }
        }
        return skip;
    }
}