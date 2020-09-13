
import java.util.*;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author sonec
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(",");
        //System.out.print(Arrays.toString(str));
        Queue<TreeNode> que = new LinkedList<>();
        if(str.length == 0) {
            return;
        }
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
        Solution sol = new Solution();
        TreeNode temp = sol.upside(head);
        que.add(temp);
        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeNode tn = que.poll();
                if (temp != tn) {
                    System.out.print(",");
                }
                if (tn.left != null) {
                    que.add(tn.left);
                }
                if (tn.right != null) {
                    que.add(tn.right);
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
class Solution{
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