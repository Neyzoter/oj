package cn.neyzoter.oj.tree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 111. 二叉树的最小深度
 * @author Charles Song
 * @date 2020-5-28
 */
public class MinDepth {
    public static void main (String[] args) {

    }
}

class Solution1_MinDepth {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public int minDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedBlockingQueue<>();
        if (root == null) {
            return 0;
        }
        q.add(root);
        int layer = 1;
        for (int num = q.size();!q.isEmpty();num = q.size()) {
            for (int i = 0; i < num; i ++) {
                TreeNode node = q.poll();
                TreeNode left = node.left;
                TreeNode right = node.right;
                if (left != null) {
                    q.add(left);
                }
                if (right != null) {
                    q.add(right);
                }
                if (right == null && left == null) {
                    return layer;
                }
            }
            layer ++;
        }
        return layer;
    }
}
