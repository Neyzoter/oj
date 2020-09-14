package cn.neyzoter.leetcode.algo.link;

import java.util.HashMap;

public class _124_MaxPathInTreeNode {
}

/**
 * AC
 * 时间：5.21%
 * 空间：5.21%
 */
class Sol1_124_MaxPathInTreeNode {
    Integer max = Integer.MIN_VALUE;
    // 保存非root的最大路径，只能选择一个左子树或者右子树
    HashMap<TreeNode, Integer> hm = new HashMap<>();
    public int maxPathSum(TreeNode root) {
        if (root.left != null) {
            maxPathSum(root.left);
        }
        if (root.right != null) {
            maxPathSum(root.right);
        }
        int thisVal = track(root, true);
        max = Math.max(max, thisVal);
        return max;
    }
    public int track(TreeNode root, boolean isRoot) {
        if (root == null) {
            return 0;
        }
        if (!isRoot && hm.containsKey(root)) {
            return hm.get(root);
        }
        int left = track(root.left, false);
        int right = track(root.right, false);
        int thisVal = root.val;
        if (isRoot) {
            if (left > 0) {
                thisVal += left;
            }
            if (right > 0) {
                thisVal += right;
            }
        } else {
            int bigger = Math.max(left, right);
            if (bigger > 0) {
                thisVal += bigger;
            }
        }
        max = Math.max(max, thisVal);
        if (!isRoot) {
            hm.put(root, thisVal);
        }
        return thisVal;
    }
}