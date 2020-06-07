package cn.neyzoter.exam.vivo.advance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <pre>
 * 测试用例
 * 4
 * 2 4 8
 * 3 4 6
 * 5 8 9 11
 * 1 6 7 10 12
 * </pre>
 *
 * @author Charles Song
 * @date 2020-6-7
 */
public class Test3 {

    public static void main(String[] args) {

        List<String> lines = new ArrayList<>();
        Scanner scanner = null;
        boolean isFirstLine = true;
        int num = 0;
        int lineN = 0;
        try {
            scanner = new Scanner(System.in);
            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                if (isFirstLine) {
                    num = Integer.parseInt(str.split(" ")[0]);
                    isFirstLine = false;
                } else {
                    lines.add(str);
                    lineN ++;
                }
                if (num == lineN) {
                    break;
                }
            }
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        ListNode start = null;
        for (int i = 0; i < num; i ++) {
            String[] strs = lines.get(i).split(" ");
            ListNode node = null;
            ListNode temp = null;
            for (String s : strs) {
                ListNode n = new ListNode(Integer.parseInt(s));
                if (node == null) {
                    node = n;
                    temp = node;
                } else {
                    node.next = n;
                    node = node.next;
                }
            }
            start = mergeTwoNodes(start, temp);
        }
        print(start);

    }

    static class ListNode {
        int val;

        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


//    private static ListNode mergeNodes(ListNode head ) {
//
//        // write your code here
//    }

    private static ListNode mergeTwoNodes(ListNode node1, ListNode node2) {
        ListNode p1 = node1;
        ListNode p2 = node2;
        if (p1 == null && p2 == null) {
            return null;
        } else if (p1 == null) {
            return p2;
        } else if (p2 == null){
            return p1;
        }
        ListNode head = node1.val > node2.val ? node2:node1;
        ListNode temp = head;
        if (head == node1) {
            p1 = p1.next;
        } else {
            p2 = p2.next;
        }
        for (;p1 != null && p2 != null;) {
            if (p1.val > p2.val) {
                head.next = p2;
                p2 = p2.next;
            } else {
                head.next = p1;
                p1 = p1.next;
            }
            head = head.next;
        }
        if (p1 != null) {
            head.next = p1;
        } else {
            head.next = p2;
        }
        return temp;
    }

    private static void print (ListNode node) {
        for (;node != null;) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" ");
            }
            node = node.next;
        }
    }


}