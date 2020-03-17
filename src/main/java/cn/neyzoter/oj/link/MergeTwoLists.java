package cn.neyzoter.oj.link;


/**
 * 21.合并两个有序链表
 */
public class MergeTwoLists {
    public static void main(String[] args){
        ListNode l1 = new ListNode(1);l1.next = new ListNode(2); l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);l2.next = new ListNode(3); l2.next.next = new ListNode(4);
//        Solution1_MergeTwoLists solution1_mergeTwoLists = new Solution1_MergeTwoLists();
//        solution1_mergeTwoLists.mergeTwoLists(l1, l2).printAll();

        Solution2_MergeTwoLists solution2_mergeTwoLists = new Solution2_MergeTwoLists();
        solution2_mergeTwoLists.mergeTwoLists(l1, l2).printAll();
    }
}

/**
 * 当作都是升序
 */
class Solution1_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

}

class Solution2_MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            merge(l1,l2);
            return l1;
        } else {
            merge(l2,l1);
            return l2;
        }
    }

    public void merge (ListNode l1, ListNode l2) {
        for (;l2 != null; ) {
            for (;;l1 = l1.next) {
                if (l1.next == null || l1.next.val > l2.val) {
                    ListNode l2_next_temp = l2.next;
                    ListNode l1_next_temp = l1.next;
                    l1.next = l2;
                    l1.next.next = l1_next_temp;
                    l2 = l2_next_temp;
                    l1 = l1.next;
                    break;
                }
            }
        }
    }

}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public void printAll() {
        System.out.print(this.val);
        if (this.next != null) {
            System.out.print(" -> ");
            this.next.printAll();
        }
    }
}