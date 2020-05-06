package cn.neyzoter.sword;

import java.util.Stack;

/**
 * 面试题09. 用两个栈实现队列
 * @author Charles Song
 * @date 2020-5-6
 */
public class StackQueue {
    public static void main (String[] args) {

    }
}

class CQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        for (;!stack1.isEmpty();) {
            stack2.push(stack1.pop());
        }
        int delVar;
        if (stack2.isEmpty()) {
            delVar = -1;
        } else {
            delVar = stack2.pop();
        }
        for (;!stack2.isEmpty();) {
            stack1.push(stack2.pop());
        }
        return delVar;
    }
}
