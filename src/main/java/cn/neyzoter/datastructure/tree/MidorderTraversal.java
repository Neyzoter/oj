package cn.neyzoter.datastructure.tree;

import java.util.Stack;

/**
 * 中序遍历
 * @author Charles Song
 * @date 2020-6-21
 */
public class MidorderTraversal {
    public static void traversalIterate (TreeNode node) {
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            if (!stack.isEmpty()) {
                node = stack.pop();
                System.out.print(node.val + " ");
                node = node.right;
            }
        }
    }
}
