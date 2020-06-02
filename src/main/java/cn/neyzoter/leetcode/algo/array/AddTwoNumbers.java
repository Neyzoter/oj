package cn.neyzoter.leetcode.algo.array;

public class AddTwoNumbers {
	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		node1.next = new ListNode(4);
		node1.next.next = new ListNode(6);

		ListNode node2 = new ListNode(5);
		node2.next = new ListNode(6);
		node2.next.next = new ListNode(8);
		
		ListNode listnode;
		Solution_AddTwoNumbers2 sol = new Solution_AddTwoNumbers2();
		listnode = sol.addTwoNumbers(node1,node2);
		
		System.out.printf("%d %d %d %d ",listnode.val,listnode.next.val,listnode.next.next.val,
				listnode.next.next.next.val);
	}
}
/**
 * 和Solution_AddTwoNumbers2思路相同
 * @author songchaochao
 *
 */
class Solution_AddTwoNumbers1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode((l1.val+l2.val)%10);
        ListNode temp1=l1.next,temp2=l2.next,sum_temp=sum;
        int c = (l1.val+l2.val)/10;//进位
        int val1,val2;
        while(temp1!=null||temp2!=null) {
        	if(temp1==null) {
        		val1 = 0;
        	}
        	else {
        		val1 = temp1.val;
        	}
        	if(temp2==null) {
        		val2 = 0;
        	}
        	else {
        		val2 = temp2.val;
        	}
//        	temp1 = temp1.next;temp2 = temp2.next;
        	sum_temp.next = new ListNode((val1+val2+c)%10);
        	c = (val1+val2+c)/10;
        	sum_temp = sum_temp.next;
        	if(temp1!=null) {
        		temp1 = temp1.next;
        	}
        	if(temp2 != null) {
        		temp2 = temp2.next;
        	}
        	
        }
        if(c!=0)
        	sum_temp.next=new ListNode(c);//可能还有进位
        return sum;
    }
}

/**
 * 和Solution_AddTwoNumbers1思路相同，实现起来更加简单
 * @author songchaochao
 *
 */
class Solution_AddTwoNumbers2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode temp1=l1,temp2=l2,sum_temp=sum;
        int c = 0;//进位
        int val1,val2;
        while(temp1!=null||temp2!=null) {
        	val1 = temp1==null?0:temp1.val;
        	val2 = temp2==null?0:temp2.val;
        	sum_temp.next = new ListNode((val1+val2+c)%10);
        	c = (val1+val2+c)/10;
        	sum_temp = sum_temp.next;
        	if(temp1!=null) {
        		temp1 = temp1.next;
        	}
        	if(temp2 != null) {
        		temp2 = temp2.next;
        	}
        	
        }
        if(c!=0) {
        	sum_temp.next=new ListNode(c);//可能还有进位
        }
        return sum.next;
    }
}
/**
 * 单链表
 * @author songchaochao
 *
 */
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}