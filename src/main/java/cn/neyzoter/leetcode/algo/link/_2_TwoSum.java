package cn.neyzoter.leetcode.algo.link;

/**
 * leetcode 两数想加
 * @author neyzoter
 */
public class _2_TwoSum {
    public static void main(String[] args) {

    }
}
class Sol1_2_TwoSum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbers(l1, l2, false);
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2, boolean c) {
        if (l1 == null && l2 == null && !c) {
            return null;
        } else if (l1 == null && l2 == null && c) {
            ListNode ln = new ListNode(1);
            return ln;
        }
        int val = 0;
        if (l1 != null) {
            val += l1.val;
            l1 = l1.next;
        }
        if (l2 != null) {
            val += l2.val;
            l2 = l2.next;
        }
        val += (c ? 1 : 0);
        c = val / 10 > 0;
        val %= 10;
        ListNode ln = new ListNode(val);
        ln.next = addTwoNumbers(l1, l2, c);
        return ln;
    }
}