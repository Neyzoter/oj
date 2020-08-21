package cn.neyzoter.exam.net;

import java.util.Arrays;
import java.util.LinkedList;

/***
 * 字符串打印
 * <pre>
 * 实现对一组无序的字母进行从小到大排序（区分大小写），当两个字母相同时，小写字母放在大写字母前。
 * 示例:
 *  {'S','y','s','t','e','m','C','a','l','l','e','r'}
 * 输出:
 * aCeellmrsSty
 * </pre>
 * @author neyzoter
 */
public class Round1Test1 {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        char[] ch = {'S','y','s','t','e','m','C','a','l','l','e','r'};
        print(ch);
    }
    public static void print(char[] ch) {
        char delta = (char) ('a' - 'A');
        LinkedList<Character> large = new LinkedList<>();
        LinkedList<Character> little = new LinkedList<>();
        for (char c : ch) {
            if (c >= 'a') {
                little.add(c);
            } else {
                large.add(c);
            }
        }
        // 数组和List转化
        Character[] lg = new Character[large.size()];
        Character[] lt = new Character[little.size()];
        large.toArray(lg);
        little.toArray(lt);
        Arrays.sort(lg);
        Arrays.sort(lt);
        int i = 0;
        int j = 0;
        for (; i < lg.length && j < lt.length; ) {
            if (lt[i] - delta <= lg[j]) {
                System.out.print(lt[i]);
                i++;
            } else {
                System.out.print(lg[j]);
                j++;
            }
        }
        if (i < lt.length) {
            printRes(lt, i);
        } else if (j < lg.length) {
            printRes(lg,j);
        }
    }
    public static void printRes(Character[] ch, int start) {
        for (int i = start; i < ch.length; i++) {
            System.out.print(ch[i]);
        }
    }
}
