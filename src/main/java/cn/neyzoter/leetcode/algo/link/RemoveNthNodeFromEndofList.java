package cn.neyzoter.leetcode.algo.link;

public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		ListNode_RemoveNthFromEnd head = new ListNode_RemoveNthFromEnd(1);
		head.next = new ListNode_RemoveNthFromEnd(2);
		head.next.next = new ListNode_RemoveNthFromEnd(3);
		head.next.next.next = new ListNode_RemoveNthFromEnd(4);
		head.next.next.next.next = new ListNode_RemoveNthFromEnd(5);
		Solution_RemoveNthFromEnd sol = new Solution_RemoveNthFromEnd();
		
		ListNode_RemoveNthFromEnd lstnd = sol.removeNthFromEnd(head,2);
		while(lstnd!=null) {
			System.out.printf("%d ",lstnd.val);
			lstnd = lstnd.next;
			if(lstnd!=null) {
				System.out.printf("-> ");
			}
		}
	}
}

class Solution_RemoveNthFromEnd {
    public ListNode_RemoveNthFromEnd removeNthFromEnd(ListNode_RemoveNthFromEnd head, int n) {
        ListNode_RemoveNthFromEnd del_node = head,pointer = head;
        for(int idx = 0;idx < n;idx++) {
        	pointer = pointer.next;//将pointer指向要删除的节点的后面第n个
        }
        if(pointer.next==null) {
        	head = head.next;
        	return head;
        }
        while(pointer.next!=null) {
        	pointer = pointer.next;
        	del_node = del_node.next;
        }
        del_node.next = del_node.next==null?null:del_node.next.next;
        return head;
    }
}


class ListNode_RemoveNthFromEnd {
    int val;
    ListNode_RemoveNthFromEnd next;
    ListNode_RemoveNthFromEnd(int x) { val = x; }
}