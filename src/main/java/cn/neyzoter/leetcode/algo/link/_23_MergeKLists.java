package cn.neyzoter.leetcode.algo.link;

/**
 * 23. 合并K个排序链表
 * @author Charles Song
 * @date 2020-6-6
 */
public class _23_MergeKLists {
    class ListNode {
        int val;
        Sol1_MergeKLists.ListNode next;
        ListNode(int x) { val = x; }
    }
    public static void main (String[] args) {
        ListNode node1 =
    }
}

/**
 * 分治法
 */
class Sol1_MergeKLists {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        ListNode node = lists[0];
        for (int i = 1; i < lists.length; i ++) {
            ListNode sec = lists[i];
            node = mergeTwoList(node, sec);
        }
        return node;
    }

    public static ListNode mergeTwoList (ListNode node1, ListNode node2) {
        if (node1 == null && node2 != null) {
            return node2;
        } else if (node1 != null && node2 == null){
            return node1;
        } else if (node1 == null && node2 == null) {
            return null;
        }
        ListNode start = node1.val < node2.val ? node1 : node2;
        ListNode p1 = node1, p2 = node2;
        ListNode temp = start;
        if (start == node1) {
            p1 = p1.next;
        } else {
            p2 = p2.next;
        }
        for (;p1 != null && p2 != null;) {
            if (p1.val > p2.val) {
                temp.next = p2;
                temp = temp.next;
                p2 = p2.next;
            } else {
                temp.next = p1;
                temp = temp.next;
                p1 = p1.next;
            }
        }
        if (p1 != null) {
            temp.next = p1;
        } else {
            temp.next = p2;
        }
        return start;
    }

    public static void printNode (ListNode node) {
        for (;node != null;) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.println(" -> ");
            }
            node = node.next;
        }
    }
}
