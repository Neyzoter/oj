package cn.neyzoter.leetcode.algo.array;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author sonec
 */
public class Test1 {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        Queue<TreeNode> que = new LinkedList<>();
        int idx = 0;
        TreeNode head = new TreeNode(Integer.parseInt(str[idx++]));
        que.add(head);
        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = que.poll();
                if (idx < str.length) {
                    int val = Integer.parseInt(str[idx++]);
                    tn.left = new TreeNode(val);
                    que.add(tn.left);
                }
                if (idx < str.length) {
                    int val = Integer.parseInt(str[idx++]);
                    tn.right = new TreeNode(val);
                    que.add(tn.right);
                }
            }
        }
        Sol_ sol = new Sol_();
        head = sol.upside(head);
        que.add(head);
        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = que.poll();
                if (head != tn) {
                    System.out.print(",");
                }
                System.out.print(tn.val);
            }
        }
    }

}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x){val =x;}

}

class Sol_ {
    TreeNode head;
    public TreeNode upside(TreeNode root) {
        if (root == null) {
                return null;
            }
            dfs(root);
            return head;
    }
    public TreeNode dfs(TreeNode node){
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            if (head == null) {
                head = node;
            }
            return node;
        }
        TreeNode left = dfs(node.left);
        TreeNode right = dfs(node.right);
        if (left != null) {
            left.left = right;
            left.right = node;
        }
        node.right = null;
        node.left = null;
        return node;
    }
}