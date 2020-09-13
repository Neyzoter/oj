package cn.neyzoter.exam.xinlang;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author sonec
 */
public class Test4Xinlang {
    public void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        Queue<cn.neyzoter.leetcode.algo.array.TreeNode> que = new LinkedList<>();
        int idx = 0;
        cn.neyzoter.leetcode.algo.array.TreeNode head = new cn.neyzoter.leetcode.algo.array.TreeNode(Integer.parseInt(str[idx++]));
        que.add(head);
        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                cn.neyzoter.leetcode.algo.array.TreeNode tn = que.poll();
                if (idx < str.length) {
                    int val = Integer.parseInt(str[idx++]);
                    tn.left = new cn.neyzoter.leetcode.algo.array.TreeNode(val);
                    que.add(tn.left);
                }
                if (idx < str.length) {
                    int val = Integer.parseInt(str[idx++]);
                    tn.right = new cn.neyzoter.leetcode.algo.array.TreeNode(val);
                    que.add(tn.right);
                }
            }
        }
        cn.neyzoter.leetcode.algo.array.Sol_ sol = new cn.neyzoter.leetcode.algo.array.Sol_();
        head = sol.upside(head);
        que.add(head);
        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                cn.neyzoter.leetcode.algo.array.TreeNode tn = que.poll();
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
    cn.neyzoter.leetcode.algo.array.TreeNode left;
    cn.neyzoter.leetcode.algo.array.TreeNode right;
    TreeNode(int x){val =x;}

}

class Sol_ {
    cn.neyzoter.leetcode.algo.array.TreeNode head;
    public cn.neyzoter.leetcode.algo.array.TreeNode upside(cn.neyzoter.leetcode.algo.array.TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return head;
    }
    public cn.neyzoter.leetcode.algo.array.TreeNode dfs(cn.neyzoter.leetcode.algo.array.TreeNode node){
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            if (head == null) {
                head = node;
            }
            return node;
        }
        cn.neyzoter.leetcode.algo.array.TreeNode left = dfs(node.left);
        cn.neyzoter.leetcode.algo.array.TreeNode right = dfs(node.right);
        if (left != null) {
            left.left = right;
            left.right = node;
        }
        node.right = null;
        node.left = null;
        return node;
    }
}