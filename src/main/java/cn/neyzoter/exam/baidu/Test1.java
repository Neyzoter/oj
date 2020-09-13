package cn.neyzoter.exam.baidu;
//
//import java.util.Scanner;
//
///**
// * Test1
// * @author neyzoter
// */
//public class Test1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
////        Integer[] num = new Integer[n];
//        int num5 = 0;
//        int num0 = 0;
//        for (int i = 0; i < n; i++) {
////            num[i] = sc.nextInt();
//            int num = sc.nextInt();
//            if (num == 5) {
//                num5++;
//            } else if (num == 0) {
//                num0++;
//            }
//        }
////        Arrays.sort(num, Collections.reverseOrder());
//        if (num0 > 0 && num5 >= 9) {
//            int num5t = num5 / 9 * 9;
//            for (int i = 0; i < num5t; i++) {
//                System.out.print(5);
//            }
//            for (int i = 0; i < num0; i++) {
//                System.out.print(0);
//            }
//        } else if (num0 > 0) {
//            System.out.println(0);
//        } else {
//            System.out.println(-1);
//        }
//
//    }
//
//}

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
        Queue<cn.neyzoter.exam.xinlang.TreeNode> que = new LinkedList<>();
        int idx = 0;
        cn.neyzoter.exam.xinlang.TreeNode head = new cn.neyzoter.exam.xinlang.TreeNode(Integer.parseInt(str[idx++]));
        que.add(head);
        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                cn.neyzoter.exam.xinlang.TreeNode tn = que.poll();
                if (idx < str.length) {
                    int val = Integer.parseInt(str[idx++]);
                    tn.left = new cn.neyzoter.exam.xinlang.TreeNode(val);
                    que.add(tn.left);
                }
                if (idx < str.length) {
                    int val = Integer.parseInt(str[idx++]);
                    tn.right = new cn.neyzoter.exam.xinlang.TreeNode(val);
                    que.add(tn.right);
                }
            }
        }
        cn.neyzoter.exam.xinlang.Solution sol = new cn.neyzoter.exam.xinlang.Solution();
        head = sol.upside(head);
        que.add(head);
        while (que.size() > 0) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                cn.neyzoter.exam.xinlang.TreeNode tn = que.poll();
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
    cn.neyzoter.exam.xinlang.TreeNode left;
    cn.neyzoter.exam.xinlang.TreeNode right;
    TreeNode(int x){val =x;}

}
class Solution{
    cn.neyzoter.exam.xinlang.TreeNode head;
    public cn.neyzoter.exam.xinlang.TreeNode upside(cn.neyzoter.exam.xinlang.TreeNode root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        return head;
    }
    public cn.neyzoter.exam.xinlang.TreeNode dfs(cn.neyzoter.exam.xinlang.TreeNode node){
        if (node == null) {
            return null;
        }

        if (node.left == null && node.right == null) {
            if (head == null) {
                head = node;
            }
            return node;
        }
        cn.neyzoter.exam.xinlang.TreeNode left = dfs(node.left);
        cn.neyzoter.exam.xinlang.TreeNode right = dfs(node.right);
        if (left != null) {
            left.left = right;
            left.right = node;
        }
        node.right = null;
        node.left = null;
        return node;
    }
}