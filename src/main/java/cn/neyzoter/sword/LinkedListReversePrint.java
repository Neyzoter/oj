package cn.neyzoter.sword;

/**
 * 面试题06. 从尾到头打印链表
 * @author Charles Song
 * @date 2020-5-5
 */
public class LinkedListReversePrint {

    public static void main (String[] args) {
        ListNode listNode1 = new ListNode(10);ListNode listNode2 = new ListNode(9);ListNode listNode3 = new ListNode(8);
        ListNode listNode4 = new ListNode(7);ListNode listNode5 = new ListNode(6);ListNode listNode6 = new ListNode(5);
        listNode1.next = listNode2;listNode2.next = listNode3; listNode3.next = listNode4;
        listNode4.next = listNode5;listNode5.next = listNode6;
        Solution1_LinkedListReversePrint solution1_linkedListReversePrint = new Solution1_LinkedListReversePrint();
        int[] result = solution1_linkedListReversePrint.reversePrint(null);
        for (int item : result) {
            System.out.print(item + " ");
        }
    }
}

/**
 * 暴力法
 */
class Solution1_LinkedListReversePrint {
    public static final int MAX_LEN = 10000;
    public int[] reversePrint(ListNode head) {
        int[] reverse = new int[MAX_LEN];
        int i;
        for (i = MAX_LEN - 1; i >= 0; i --) {
            if (head != null) {
                reverse[i] = head.val;
                head = head.next;
            } else {
                break;
            }
        }
        int len = MAX_LEN - i - 1;
        int[] result = new int[len];
        System.arraycopy(reverse,i+1,result,0,len);
        return result;
    }
}

