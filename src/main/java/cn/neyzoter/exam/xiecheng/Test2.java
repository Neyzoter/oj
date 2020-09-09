package cn.neyzoter.exam.xiecheng;

import java.util.HashMap;
import java.util.Scanner;

/**
 * AC 88%
 */
public class Test2 {
    public static boolean flag = false;
    public static final String CIRCLE = "--circular dependency";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().split(" ");
        dfs(str, new StringBuilder(), 0, new HashMap<>());
    }

    public static void dfs(String[] str, StringBuilder sb, int i, HashMap<Character, Integer> hm) {
        if (i == str.length) {
            System.out.print(sb);
            if (flag) {
                System.out.print(CIRCLE);
            }
            System.out.println();
            return;
        }
        for (int j = 0; j < str[i].length(); j++) {
            char ch = str[i].charAt(j);
            sb.append(ch);
            boolean flagTemp = flag;
            if (hm.getOrDefault(ch, 0) != 0) {
                flag = true;
            }
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
            dfs(str, sb, i + 1, hm);
            sb.deleteCharAt(i);
            hm.put(ch, hm.get(ch) - 1);
            flag = flagTemp;
        }
    }
}
