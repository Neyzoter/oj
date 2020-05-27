package cn.neyzoter.sword;

import java.util.List;

/**
 * 面试题18. 删除链表的节点
 * @author Charles Song
 * @date 2020-5-27
 */
public class _18_DeleteNode {
    public static void main (String[] args) {

    }
}

class Solution1_deleteNode {
    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode p1 = head;
        ListNode p2 = head.next;
        for (;p2 != null;) {
            if (p2.val == val) {
                p1.next = p2.next;
                return head;
            } else {
                p1 = p1.next;
                p2 = p2.next;
            }
        }
        return head;
    }
}
