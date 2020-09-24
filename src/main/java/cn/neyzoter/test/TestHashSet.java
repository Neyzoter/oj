package cn.neyzoter.test;

import java.util.HashSet;

/**
 * 测试HashSet
 * @author Charles Song
 * @date 2020-5-6
 */
public class TestHashSet {
    public static void main (String[] args) {
        // HashSet可以设置初始化大小和装填因子
        HashSet<String> set = new HashSet(10, 0.8F);
        System.out.println("Inited set size : " + set.size());
        set.add("1");set.add("2");set.add("3");set.add("4");set.add("5");set.add("6");set.add("7");System.out.println("set size : " + set.size());
        set.add("8");set.add("9");set.add("10");set.add("11");set.add("12");set.add("13");set.add("14");set.add("15");set.add("16");set.add("17");set.add("18");
        System.out.println("Added set size : " + set.size());

//        set.add(null);
        boolean ct = set.contains(null);
        System.out.println(ct);
    }
}
