package cn.neyzoter.test;


import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 测试Enumeration
 * @author Charles Song
 * @date 2020-5-5
 */
public class TestIterator {
    public static void main (String[] args) {
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
}
