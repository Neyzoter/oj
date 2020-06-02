package cn.neyzoter.leetcode.algo.dynamic;

/**
 * 96.不同的二叉搜索树
 */
public class DiffBinarySearchTree {
    public static void main(String[] args){
        int n = 0;
        Solution1_DiffBinarySearchTree solution1_diffBinarySearchTree = new Solution1_DiffBinarySearchTree();
        System.out.println("n = " + n + "\toutput = "+solution1_diffBinarySearchTree.numTrees(n));
    }
}

/**
 * 动态规划
 */
class Solution1_DiffBinarySearchTree {
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        // 初始化为0
        for (int i = 0 ; i < n + 1; i ++) {
            dp[i] = 0;
        }
        dp[0] = 1;
        int left = 0;int right = 0;
        for (int i = 1; i < n + 1; i ++) {
            for (int j = 1; j < i + 1; j ++) {
                left = j - 1;
                right = i - j;
                dp[i] += dp[left] * dp[right];
            }
        }
        return dp[n];
    }
}