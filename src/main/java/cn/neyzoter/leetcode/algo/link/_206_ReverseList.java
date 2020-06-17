package cn.neyzoter.leetcode.algo.link;

/**
 * 206. 反转链表
 * @author Charles Song
 * @date 2020-6-17
 */
public class _206_ReverseList {
    public static void main (String[] args) {

    }
}

class Sol1_ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }
}