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
        iter.forEachRemaining(System.out::println);
    }
}
