package cn.neyzoter.leetcode.weekcp.week20_10_04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 2020年10月04日周赛
 *
 * @author neyzoter
 */
public class Test2_5532 {
    public static void main(String[] args) {
        Sol sol = new Sol();
        int[] nums = {3,6,7,7,0};
//        Arrays.sort(nums);
//        System.out.println(sol.findSmaller(nums, 0));
        System.out.println(sol.specialArray(nums));
    }
}
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        Integer lastVal;
        int layer = -1;
        while (!que.isEmpty()) {
            int size = que.size();
            lastVal = null;
            boolean inc = false;
            boolean oushu = true;
            layer++;
            // 偶数层
            if (layer % 2 == 0) {
                // 数字为奇数
                oushu = false;
                // 递增
                inc = true;
            }
            for (int i = 0; i < size; i++) {
                TreeNode tn = que.poll();
                if (oushu) {
                    if (tn.val % 2 != 0) {
                        return false;
                    }
                } else {
                    if (tn.val % 2 == 0) {
                        return false;
                    }
                }
                if (lastVal == null) {
                    lastVal = tn.val;
                } else {
                    int delta = lastVal - tn.val;
                    if ((delta > 0) == inc || delta == 0) {
                        return false;
                    }
                    lastVal = tn.val;
                }
                if (tn.left != null) {
                    que.add(tn.left);
                }
                if (tn.right != null) {
                    que.add(tn.right);
                }
            }
        }
        return true;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}