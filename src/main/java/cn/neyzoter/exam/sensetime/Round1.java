package cn.neyzoter.exam.sensetime;

public class Round1 {
    static ListNode newHead;
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;node2.next = node3;
        ListNode head = reverseList(node1);
        for (ListNode node = head; node != null; node = node.next) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
        }
    }
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        reverseList(head, null);
        return newHead;
    }
    public static void reverseList(ListNode head, ListNode last) {
        if (head.next == null) {
            newHead = head;
            head.next = last;
            return;
        }
        reverseList(head.next, head);
        head.next = last;
    }
}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
