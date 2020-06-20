package cn.neyzoter.leetcode.algo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * @author Charles Song
 * @date 2020-6-20
 */
public class _102_LevelOrder {
    public static void main (String[] args) {
        Sol1_102_LevelOrder sol = new Sol1_102_LevelOrder();
        System.out.println(sol.levelOrder(new Sol1_102_LevelOrder.TreeNode(2)));
    }
}
class Sol1_102_LevelOrder {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> lists = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        for (;queue.size() != 0;) {
            int size = queue.size();
            List<Integer> list = new LinkedList<>();
            lists.add(list);
            for (int num = 0; num < size; num ++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return lists;
    }
}