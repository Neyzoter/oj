package cn.neyzoter.sword;

import java.util.*;

/**
 * 剑指 Offer 32 - III. 从上到下打印二叉树 III
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 * @author neyzoter
 */
public class _32III_StackPushPop {
    public static void main(String[] args) {

    }
}


class Sol1_32III_StackPushPop {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> list = new ArrayList<>();
        boolean left2Right = true;
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new ArrayList<>();
            Deque<TreeNode> queueTemp = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.pollLast();
                subList.add(node.val);
                // 上一层是从左到右，为了保证数字是按照从左到右或者从右到左，则需要分类添加
                if (left2Right) {
                    if (node.left != null) {
                        queueTemp.add(node.left);
                    }
                    if (node.right != null) {
                        queueTemp.add(node.right);
                    }
                } else { // 上一层是从右到左
                    if (node.right != null) {
                        queueTemp.add(node.right);
                    }
                    if (node.left != null) {
                        queueTemp.add(node.left);
                    }
                }
            }
            queue = queueTemp;
            list.add(subList);
            left2Right = !left2Right;
        }
        return list;
    }
}