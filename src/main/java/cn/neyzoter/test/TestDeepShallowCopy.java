package cn.neyzoter.test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 测试深拷贝和浅拷贝
 * @author Neyzoter Sone
 * @date 2019-1-11
 */
public class TestDeepShallowCopy {
    public static void main(String[] args) {
        TestDeepShallowCopy testDeepShallowCopy = new TestDeepShallowCopy();
        System.out.println("testListEquals");
        testDeepShallowCopy.testListEquals();
        System.out.println("testArrayEquals");
        testDeepShallowCopy.testArrayEquals();
        System.out.println("testLinkedList");
        testDeepShallowCopy.testLinkedList();
        System.out.println("testArrayList");
        testDeepShallowCopy.testArrayList();

    }

    /**
     * List浅拷贝
     */
    public void testListEquals () {
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);list1.add(2);list1.add(3);
        List<Integer> list2 = list1;
        list2.add(4);
        list2.set(0,20);
        System.out.println(list1);System.out.println(list2);
    }

    /**
     * Array浅拷贝
     */
    public void testArrayEquals () {
        int[] arrays = new int[5];
        for (int i = 0; i < arrays.length ; i ++) {
            arrays[i] = i + 2 + i / 2;
        }
        int[] arrays_cp = arrays;
        System.out.println(arrays.toString());System.out.println(arrays.toString());
    }
    /**
     * 测试LinkedList拷贝方法
     * 确实是深拷贝
     */
    public void testLinkedList () {
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);list1.add(2);list1.add(3);
        List<Integer> list2 = new LinkedList<>(list1);
        list2.set(0,20);
        list2.add(4);
        System.out.println(list1);System.out.println(list2);
    }
    /**
     * 测试ArrayList拷贝方法
     * 确实是深拷贝
     */
    public void testArrayList () {
        List<Integer> list1 = new ArrayList<>(10);
        list1.add(1);list1.add(2);list1.add(3);
        List<Integer> list2 = new ArrayList<>(list1);
        list2.set(0,7);
        list2.add(4);
        System.out.println(list1);System.out.println(list2);
    }
}
