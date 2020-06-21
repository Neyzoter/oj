package cn.neyzoter.datastructure.tree;

/**
 * 测试app
 * @author Charles Song
 * @date 2020-6-21
 */
public class TreeApplicaiton {
    public static void main (String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        /**
         * <pre>
         *        3
         *   2        4
         *       1        5
         * </pre>
         */
        node3.left = node2;node2.right = node1;
        node3.right = node4; node4.right = node5;
        PreorderTraversal.traversalIterate(node3);
        System.out.println();
        PreorderTraversal.traversalRecursive(node3);
        System.out.println();
        MidorderTraversal.traversalIterate(node3);
        System.out.println();
        BackorderTraversal.traversalIterate(node3);
    }
}
