package cn.neyzoter.test.collection.set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

/**
 * 测试Set
 * @author Charles Song
 * @date 2020-5-20
 */
public class TestSet {
    public static void main (String[] args) {
        testHashSet();
        testLinkedHashSet();
    }

    /**
     * HashSet通过HashMap来存储数据（暴露在外部）<br/>
     * 但是HashSet有个default方法，可以通过LinkedHashMap实现<br/>
     * default方法用于子类的构造，比如LinkedHashSet
     */
    public static void testHashSet () {
        HashSet<String> set = new HashSet<>(10, 0.75F);
        /**
         * 不是按照顺序存储的
         */
        set.add("123");set.add("345");set.add("549");
        set.add("54");set.add("49");set.add("1");
        Object[] strs = set.toArray();
        System.out.println(Arrays.toString(strs));
    }

    /**
     * LinkedHashSet集成HashSet，底层采用LinkedHashMap实现<br/>
     * 需要注意的是HashSet暴露出来的方法是通过HashMap实现的<br/>
     * 只有像LinkedHashSet这种继承了HashSet的类才可以通过HashSet的LinkedHashMap实现方法构造
     *
     */
    public static void testLinkedHashSet () {
        LinkedHashSet<String> set = new LinkedHashSet<>();
        /**
         * 按照顺序存储
         */
        set.add("231");set.add("2321");set.add("532");
        set.add("2");set.add("1");
        Object[] strs = set.toArray();
        System.out.println(Arrays.toString(strs));
    }
}
