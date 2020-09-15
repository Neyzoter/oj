package cn.neyzoter.exam.xiaomi;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            if (str.length() == 0) {
                System.out.println("true");
                continue;
            }
            Stack<Character> stack = new Stack<>();
            boolean printed = false;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch == '}' || ch == ']' || ch == ')') {
                    if (stack.isEmpty()) {
                        System.out.println("false");
                        printed = true;
                        break;
                    } else {
                        char conv = convert(ch);
                        if (stack.peek().equals(conv)) {
                            stack.pop();
                        } else {
                            System.out.println("false");
                            printed = true;
                            break;
                        }
                    }
                } else {
                    stack.push(ch);
                }
            }
            if (!printed) {
                System.out.println(stack.isEmpty() ? "true" : "false");
            }
        }

    }
    public static char convert(char ch) {
        switch (ch) {
            case '}':
                return '{';
            case ']':
                return '[';
            case ')':
                return '(';
        }
        return ' ';
    }
}
