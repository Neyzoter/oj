package cn.neyzoter.leetcode.algo.link;

import java.util.HashMap;

public class _124_MaxPathInTreeNode {
    public static void main(String[] args) {

    }
}

/**
 * AC
 * 时间：5.21%
 * 空间：62.32%
 */
class Sol1_124_MaxPathInTreeNode {
    Integer max = Integer.MIN_VALUE;
    // 保存非root的最大路径，只能选择一个左子树或者右子树
    HashMap<TreeNode, Integer> notRootHm = new HashMap<>();
    public int maxPathSum(TreeNode root) {
        int left = track(root.left);
        int right = track(root.right);
        int thisVal = root.val;
        // root可以两边都加上
        if (left > 0) {
            thisVal += left;
        }
        if (right > 0) {
            thisVal += right;
        }
        return max = Math.max(thisVal, max);
    }
    public int track(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (notRootHm.containsKey(root)) {
            return notRootHm.get(root);
        }
        int left = track(root.left);
        int right = track(root.right);
        int rootVal = root.val;
        int notRootVal = root.val;
        // root可以两边都加上
        if (left > 0) {
            rootVal += left;
        }
        if (right > 0) {
            rootVal += right;
        }
        // 非root只能选择一边
        int bigger = Math.max(left, right);
        if (bigger > 0) {
            notRootVal += bigger;
        }
        max = Math.max(max,  rootVal);
        notRootHm.put(root, notRootVal);
        return notRootVal;
    }
}