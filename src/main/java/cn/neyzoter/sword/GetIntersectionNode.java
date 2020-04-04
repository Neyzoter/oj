package cn.neyzoter.sword;

/**
 * 面试题52. 两个链表的第一个公共节点
 * @author Charles Song
 * @date 2020-4-4
 */
public class GetIntersectionNode {
    public static void main (String[] args) {
    }
}

class Solution1_GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode node1, node2;
        int flag = 0;
        if (headA == null || headB == null) {
            return null;
        }
        for (node1 = headA, node2 = headB; node1 != node2 && flag <= 1;) {
            if (node1.next == null) {
                node1 = headB;
                flag ++;
            } else {
                node1 = node1.next;
            }
            if (node2.next == null) {
                node2 = headA;
            } else {
                node2 = node2.next;
            }
        }
        if (flag > 1) {
            return null;
        } else {
            return node1;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}