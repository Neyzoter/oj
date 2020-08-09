package cn.neyzoter.leetcode.algo.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 8. 字符串转换整数 (atoi)
 * @author sonec
 */
public class _8_Atoi {
    public static void main(String[] args) {
        System.out.println(myAtoi("-91283472332"));
    }

    public static int myAtoi(String str) {
        HashMap<String, Set<String>> states = initState();
        String st = "start";
        long num = 0;
        int sign = 1;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Set<String> set = states.get(st);
            String s = getState(ch);
            // 更新
            if (set.contains(s)) {
                if ("start".equals(st) || "space".equals(st)) {
                    if (ch == '-') {
                        sign = -1;
                    }
                }
                st = s;
                if ("number".equals(st)) {
                    num = num * 10 + sign * (ch - '0');
                    if (num < Integer.MIN_VALUE) {
                        return Integer.MIN_VALUE;
                    } else if (num > Integer.MAX_VALUE) {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                break;
            }
        }
        if (!"number".equals(st)) {
            return 0;
        }
        return (int) num;
    }

    public static String getState(char c) {
        if (c == '+' || c == '-') {
            return "sign";
        } else if (c <= '9' && c >= '0') {
            return "number";
        } else if (c == ' ') {
            return "space";
        } else {
            return "Others";
        }
    }
    public static HashMap<String, Set<String>> initState() {
        HashMap<String, Set<String>> hashMap = new HashMap<>();
        String start = "start";
        String space = "space";
        String sign = "sign";
        String number = "number";

        Set<String> set = new HashSet<>();
        set.add(number);set.add(space);set.add(sign);
        hashMap.put(start, set);

        set = new HashSet<>();
        set.add(sign);set.add(number);set.add(space);
        hashMap.put(space, set);

        set = new HashSet<>();
        set.add(number);
        hashMap.put(sign, set);

        set = new HashSet<>();
        set.add(number);
        hashMap.put(number,set);

        return hashMap;
    }
}
