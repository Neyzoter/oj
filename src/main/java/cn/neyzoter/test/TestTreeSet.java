package cn.neyzoter.test;

import java.util.TreeSet;

/**
 * 测试树集
 * @author Charles Song
 * @date 2020-5-6
 */
public class TestTreeSet {
    public static void main (String[] args) {
        testSort();

    }

    /**
     * 测试排序情况
     */
    public static void testSort () {
        /**
         * 数字
         */
        TreeSet<Integer> setInt = new TreeSet<>();
        setInt.add(1);setInt.add(4);setInt.add(2);
        // TreeSet将数字进行了排序
        for (Integer var : setInt) {
            System.out.print(var + " ");
        }
        /**
         * 字符串
         */
        TreeSet<String> setStr = new TreeSet<>();
        setStr.add("a");setStr.add("d");setStr.add("c");
        // TreeSet将字符串进行了排序
        for (String str : setStr) {
            System.out.print(str + " ");
        }
    }

}
