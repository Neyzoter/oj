package cn.neyzoter.leetcode.algo.array;

import com.sun.xml.internal.ws.policy.jaxws.SafePolicyReader;

import java.util.List;

/**
 * 24. 两两交换链表中的节点
 * @author Charles Song
 * @date 2020-6-20
 */
public class _24_SwapPairs {
    public static void main (String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        Sol1_24_SwapPairs sol = new Sol1_24_SwapPairs();
        sol.swapPairs(node1);
    }
}

class Sol1_24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode headTemp = head.next;
        ListNode firstTemp = null;
        for (ListNode first = head; first != null; ) {
            ListNode second = first.next;
            if (second == null) {
                return headTemp;
            }
            ListNode secNext = second.next;
            if (firstTemp != null) {
                firstTemp.next = second;
            }
            second.next = first;
            first.next = secNext;
            firstTemp = first;
            first = secNext;
        }

        return headTemp;
    }
}

class Sol2_24_SwapPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode first = head;
        ListNode second = head.next;
        first.next = swapPairs(second.next);
        second.next = first;
        return second;

    }
}
