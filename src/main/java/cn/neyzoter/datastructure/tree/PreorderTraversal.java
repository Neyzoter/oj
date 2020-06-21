package cn.neyzoter.datastructure.tree;


import java.util.Stack;

/**
 * 前序遍历
 * @author Charles Song
 * @date 2020-6-21
 */
public class PreorderTraversal {
    public static void traversalRecursive (TreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.val + " ");
        traversalRecursive(node.left);
        traversalRecursive(node.right);
    }

    public static void traversalIterate (TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                System.out.print(node.val + " ");
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                node = node.right;
            }
        }
    }
}
