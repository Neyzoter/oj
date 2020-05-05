package cn.neyzoter.test;


import java.util.*;

/**
 * 测试Enumeration
 * @author Charles Song
 * @date 2020-5-5
 */
public class TestIterator {
    public static void main (String[] args) {
        testIter();
        testListIter();
    }
    public static void testIter () {
        /**
         * Iterator测试
         */
        Collection<String> col = new ArrayList<>(10);
        col.add("123");col.add("234");col.add("345");col.add("456");
        Iterator<String> iter = col.iterator();
        System.out.println("* Origin");
        iter.forEachRemaining(System.out::println);

        // 使用iterator实现删除元素
        iter = col.iterator();
        for (;iter.hasNext();) {
            String str = iter.next();
            if (str.equals("123")) {
                // 调用remove前必须调用next
                // 下次remove也必须再次调用next
                iter.remove();
            }
        }
        System.out.println("* Removed \"123\"");
        iter = col.iterator();
        iter.forEachRemaining(System.out::println);
    }

    public static void testListIter () {
        /**
         * ListIterator测试
         */
        List<String> list = new LinkedList<>();
        list.add("123");list.add("234");list.add("345");list.add("456");
        ListIterator<String> listIterator = list.listIterator();
        listIterator.next();listIterator.next();
        System.out.println("previous index : " + listIterator.previousIndex());
        // previous可以将index向前移动
        System.out.println("previous(index --) : " + listIterator.previous());
        System.out.println("previous index : " + listIterator.previousIndex());
        System.out.println("next index : " + listIterator.nextIndex());
        System.out.println("(List)Iterator 可以看作在元素之间的一个元素，next和previous的Index只相差1");
        for (;listIterator.hasNext();) {
            String str = listIterator.next();
            if (str.equals("345")) {
                System.out.println("Get \"345\"");
            }

        }
        // 123 234 | 345 456   <-
        listIterator.previous();listIterator.previous();
        // 123 234 | 101010 456
        listIterator.set("101010");
        // 123 234 101010 456 | ->
        listIterator.next();listIterator.next();
        // 123 234 101010 202020 |
        listIterator.set("202020");
        listIterator = list.listIterator();
        listIterator.forEachRemaining(System.out::println);
        System.out.println("ListIterator.set 设置的是Iterator当前所获取的元素(A|B，上次调用的next则为A，上次调用的previous则为B)");
    }
}
