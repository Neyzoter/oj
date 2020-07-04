package cn.neyzoter.leetcode.algo.stack;

import java.util.Stack;

/**
 * 227. 基本计算器 II
 * @author Charles Song
 * @date 2020-7-4
 */
public class _227_Calculate {
    public static void main (String[] args) {
        String s = "3/2";
        Sol1_227_Calculate sol = new Sol1_227_Calculate();
        System.out.println(sol.calculate(s));
    }
}

class Sol1_227_Calculate {
    public int calculate(String s) {
        char sign = '+';
        int val = 0;
        Stack<Integer> stack = new Stack<>();
        for (int r = 0; r < s.length(); ) {
            char ch = s.charAt(r);
            if (isDigital(ch)) {
                val = val * 10 + (ch - '0');
            }
            if (r == s.length() - 1 || (!isDigital(ch) && ch != ' ')){
                switch (sign) {
                    case '+':
                        stack.push(val);
                        break;
                    case '-':
                        stack.push(-val);
                        break;
                    case '*':
                        int v = stack.pop() * val;
                        stack.push(v);
                        break;
                    case '/' :
                        v = stack.pop() / val;
                        stack.push(v);
                        break;
                    default:
                        break;
                }
                sign = ch;
                val = 0;
            }
            r ++;
        }
        int result = 0;
        for (;!stack.isEmpty();) {
            result += stack.pop();
        }
        return result;
    }

    public static boolean isDigital(char ch) {
        if (ch <= '9' && ch >= '0') {
            return true;
        }
        return false;
    }

    public static boolean isSpace(char ch) {
        if (ch == ' ') {
            return true;
        }
        return false;
    }
}
