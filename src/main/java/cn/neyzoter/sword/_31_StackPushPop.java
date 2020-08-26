package cn.neyzoter.sword;

import java.util.Stack;

public class _31_StackPushPop {
    public static void main(String[] args) {

    }
}

/**
 * 支持数字相同
 */
class Sol1_31_StackPushPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        if (pushed.length != popped.length) {
            return false;
        }
        return validateStackSequences(pushed, 0, stack, popped, 0);
    }

    public boolean validateStackSequences(int[] pushed, int psi, Stack<Integer> stack, int[] popped, int ppi) {
        if (ppi == popped.length) {
            return true;
        }
        if (!stack.empty()) {
            int top = stack.peek();
            if (popped[ppi] == top) {
                stack.pop();
                if (validateStackSequences(pushed, psi, stack, popped, ppi + 1)) {
                    return true;
                }
                stack.push(top);
            }
        }
        if (psi >= pushed.length) {
            return false;
        }
        if (pushed[psi] == popped[ppi]) {
            if (validateStackSequences(pushed, psi + 1, stack, popped, ppi + 1)) {
                return true;
            }
        } else {
            stack.push(pushed[psi]);
            if (validateStackSequences(pushed, psi + 1, stack, popped, ppi)) {
                return true;
            }
        }
        return false;
    }
}

/**
 * 不支持重复数字
 */
class Sol2_31_StackPushPop {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        if (pushed.length != popped.length) {
            return false;
        }
        int i = 0;
        for (int e : pushed) {
            stack.push(e);
            while (!stack.empty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.empty();
    }
}
