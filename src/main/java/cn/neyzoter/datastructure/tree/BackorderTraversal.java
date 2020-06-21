package cn.neyzoter.datastructure.tree;

import java.util.Stack;

/**
 * 后序遍历
 * @author Charles Song
 * @date 2020-6-21
 */
public class BackorderTraversal {
    public static void traversalIterate (TreeNode node) {
        Stack<StateTreeNode> stack = new Stack<>();
        StateTreeNode snode;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(new StateTreeNode(node));
                node = node.left;
            }
            if (!stack.isEmpty()) {
                snode = stack.peek();
                // 检查是否是第一次遍历（中序），是则不需要pop
                if (snode.isFirst()) {
                    snode.setNotFirst();
                    node = snode.getNode().right;
                } else { // 后序了，需要pop
                    stack.pop();
                    System.out.print(snode.getNode().val + " ");
                }
            }
        }
    }
}
