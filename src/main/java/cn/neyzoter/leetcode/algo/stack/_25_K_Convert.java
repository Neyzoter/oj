package cn.neyzoter.leetcode.algo.stack;

import java.util.Stack;

/**
 * 25. K 个一组翻转链表
 */
public class _25_K_Convert {
    public static void main(String[] args) {

    }
}

class Sol1_25_K_Convert {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode globalHead = null;
        ListNode lastTail = null;
        ListNode temp = head;
        Stack<ListNode> stack = new Stack<>();
        while(temp != null) {
            int i = 0;
            for (; i < k; ) {
                stack.push(temp);
                temp = temp.next;
                i++;
                if (temp == null) {
                    break;
                }
            }
            // 正常k个
            if (i == k) {
                while(stack.size() > 0) {
                    ListNode ln = stack.pop();
                    if (globalHead == null) {
                        globalHead = ln;
                    }
                    if (lastTail != null) {
                        lastTail.next = ln;
                    }
                    lastTail = ln;
                }
                if (lastTail != null) {
                    lastTail.next = null;
                }
                // 不到k个
            } else {
                if (globalHead == null) {
                    return head;
                } else {
                    while (stack.size() > 1) {
                        stack.pop();
                    }
                    if (lastTail != null) {
                        lastTail.next = stack.pop();
                    }
                }
            }
        }
        return globalHead;
    }
}

class Sol2_25_K_Convert {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode subHead = null;
        ListNode lastTail = null;
        ListNode thisTail = new ListNode(0);
        thisTail.next = head;
        ListNode newHead = null;
        while (thisTail != null) {
            subHead = thisTail.next;
            for (int i = 0; i < k; i++) {
                thisTail = thisTail.next;
                if (thisTail == null) {
                    return newHead;
                }
            }
            ListNode[] lns = revert(subHead, thisTail);
            if (lastTail != null) {
                lastTail.next = lns[0];
                //System.out.println(lastTail.val);
            }
            if (newHead == null) {
                newHead = lns[0];
            }
            // 更新tail
            lastTail = lns[1];
            thisTail = lns[1];
            //System.out.println(lastTail.next.next.val);
        }
        return newHead;
    }
    /**
     * 反转链表一部分
     * @param head 头部
     * @param tail 尾部，包含
     * @return 反转后的结果
     */
    public ListNode[] revert(ListNode head, ListNode tail) {
        ListNode prev = tail.next;
        ListNode p = head;
        while (prev != tail) {
            ListNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        return new ListNode[]{tail, head};
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