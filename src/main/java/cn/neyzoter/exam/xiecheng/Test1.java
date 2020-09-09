package cn.neyzoter.exam.xiecheng;

import java.util.*;

/**
 * AC 89%
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] mg = sc.nextLine().toCharArray();
        String str = sc.nextLine();

        String replace = sc.nextLine();
        if (mg.length == 0) {
            System.out.println(str);
            return;
        }
        HashMap<Character, Integer> mghm = new HashMap<>();
        for (char c : mg) {
            mghm.put(c, mghm.getOrDefault(c, 0) + 1);
        }
        HashMap<Character, Integer> win = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int valid = mghm.size();
        boolean printThisWord = false;
        for (int i = 0; i < str.length();i++) {
            char ch = str.charAt(i);
            if (notWord(ch)) {
                if (printThisWord || valid != 0) {
                    // 打印这个单词
                    System.out.print(sb);
                    printThisWord = false;
                } else {
                    // 打印替换方案
                    System.out.print(replace);
                }
                valid = mghm.size();
                System.out.print(ch);
                sb = new StringBuilder();
                win.clear();
            } else {
                sb.append(ch);
                if (printThisWord || !mghm.containsKey(ch)) {
                    printThisWord = true;
                } else {
                    win.put(ch, win.getOrDefault(ch, 0) + 1);
                    if (win.get(ch).equals(mghm.get(ch))) {
                        valid--;
                    } else if (win.get(ch) > (mghm.get(ch))) {
                        printThisWord = true;
                    }
                }
                if (i == str.length() - 1) {
                    if (printThisWord || valid != 0) {
                        // 打印这个单词
                        System.out.print(sb);
                    } else {
                        // 打印替换方案
                        System.out.print(replace);
                    }
                }
            }
        }
    }
    public static boolean notWord(char ch) {
        return ch < 'A' || (ch > 'Z' && ch < 'a') || ch > 'z';
    }
}
