package cn.neyzoter.leetcode.algo.stack;

import java.util.Stack;

/**
 * 20 有效的括号
 */
public class ValidBrackets {
    public static void main(String args[]){
        String[] strings = {"()","()[]{}","(]","([)]","{[]}"};
        Solution1_ValidBrackets solution1_validBrackets = new Solution1_ValidBrackets();
        for (String s : strings){
            System.out.println(s + "\n  " + solution1_validBrackets.isValid(s));
        }

    }
}

class Solution1_ValidBrackets{
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Character ch_pop;
        for (Character ch : s.toCharArray()){
            if (stack.isEmpty()){
                stack.push(ch);
            }else {
                ch_pop = stack.pop();
                boolean isCouple = (ch_pop.equals('(') && ch.equals(')')) || (ch_pop.equals('{') && ch.equals('}')) || (ch_pop.equals('[') && ch.equals(']'));
                if (!isCouple){
                    stack.push(ch_pop);
                    stack.push(ch);
                }

            }
        }
        return stack.isEmpty()?true:false;
    }
}