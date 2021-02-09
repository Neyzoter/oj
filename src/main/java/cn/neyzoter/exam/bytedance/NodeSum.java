package cn.neyzoter.exam.bytedance;

import java.util.Arrays;

/**
 * 链表相加
 * @author Charles Song
 * @date 2020-7-9
 */
public class NodeSum {
    public static void main(String[] args) {
        Node node1 = new Node(5);
        node1.next = new Node(4);
        node1.next.next = new Node(7);
        Node node2 = new Node(3);
        node2.next = new Node(7);
        node2.next.next = new Node(3);
        Node node = add(node1, node2);
    }
    public static Node add (Node a, Node b) {
        int c = 0;
        Node head = new Node(0);
        Node temp = head;
        boolean first = true;
        for (;a != null || b != null;) {
            int aval = a != null ? a.val : 0;
            int bval = b != null ? b.val : 0;
            int sum = aval + bval + c;
            c = sum / 10;
            sum = sum % 10;
            if (first) {
                head.val = sum;
                temp = head;
                first = false;
            } else {
                head.next = new Node(sum);
                head = head.next;
            }
            a = a != null ? a.next : a;
            b = b != null ? b.next : b;
        }
        if (c != 0) {
            head.next = new Node(c);
        }
        return temp;
    }
}

class Node {
    int val;
    Node next;
    public Node(int v) {
        val = v;
    }
}