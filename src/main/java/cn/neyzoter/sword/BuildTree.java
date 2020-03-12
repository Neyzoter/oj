package cn.neyzoter.sword;

/**
 * 面试题07. 重建二叉树
 * @author Neyzoter Song
 * @date 2020-3-12
 */
public class BuildTree {
    public static void main (String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        Solution1_BuildTree solution1_buildTree = new Solution1_BuildTree();
        TreeNode treeNode = solution1_buildTree.buildTree(preorder, inorder);
    }
}

/**
 * 递归法
 */
class Solution1_BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode treeNode = buildTree(preorder,0, preorder.length, inorder, 0, inorder.length);
        return treeNode;
    }

    /**
     * buildTree<br/>
     * @apiNote p2 - p1 == i2 - i1 is true
     * @param preorder preorder
     * @param p1 preorder start from
     * @param p2 preorder end with (not include)
     * @param inorder inorder
     * @param i1 inorder start from
     * @param i2 inorder end with (not include)
     * @return TreeNode
     */
    public TreeNode buildTree(int[] preorder,int p1, int p2, int[] inorder, int i1, int i2) {
        TreeNode treeNode = null;
        if (p2 - p1 == 0) {
            treeNode = null;
        } else {
            // find root node
            treeNode = new TreeNode(preorder[p1]);
            int inorderLeftEndNew = i1;
            int preorderLeftEndNew;
            for (; inorderLeftEndNew < i2; inorderLeftEndNew ++) {
                if (inorder[inorderLeftEndNew] == treeNode.val) {
                    break;
                }
            }
            preorderLeftEndNew = p1 + inorderLeftEndNew - i1 + 1;
            treeNode.left = buildTree(preorder, p1 + 1, preorderLeftEndNew,inorder, i1, inorderLeftEndNew);
            treeNode.right = buildTree(preorder, preorderLeftEndNew, p2,inorder, inorderLeftEndNew + 1, i2);
        }
        return treeNode;
    }
}

/**
 * 结构体
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}