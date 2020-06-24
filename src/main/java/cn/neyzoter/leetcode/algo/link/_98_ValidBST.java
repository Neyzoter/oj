package cn.neyzoter.leetcode.algo.link;

/**
 * 98. 验证二叉搜索树
 * @author Charles Song
 * @date 2020-6-24
 */
public class _98_ValidBST {
    public static void main (String[] args) {

    }
}

class Sol1_98_ValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    public boolean isValidBST (TreeNode root, TreeNode max, TreeNode min) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val	>= max.val) {
            return false;
        }
        if (min != null && root.val	<= min.val) {
            return false;
        }

        return isValidBST(root.left, root, min) && isValidBST(root.right, max, root);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}