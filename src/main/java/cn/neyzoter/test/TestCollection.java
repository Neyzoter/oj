package cn.neyzoter.test;

import java.util.*;

/**
 * 测试集合
 * @author Charles Song
 * @date 2020-4-19
 */
public class TestCollection {
    public static void main (String[] args) {
//        testCollecionRm();
//        testCompare();
        testCollectionNotAllowSame();
    }

    /**
     * 测试collection的remove和List
     */
    public static void testCollecionRm () {
        Collection<String> col = new ArrayList<>();
        col.add("1");col.add("2");col.add("3");
        // 注意collection删除的是具体的对象
        col.remove(1);
        System.out.println("Collection remove 1 : " + col.size());
        List<String> list = new ArrayList<>();
        list.add("1");list.add("2");list.add("3");
        // list删除的index
        list.remove(1);
        System.out.println("List remove 1 : " + list.size());
        // list删除的obj
        list.remove("1");
        System.out.println("List remove \"1\" : " + list.size());
    }

    /**
     * 测试Comparable和Comparator
     */
    public static void testCompare () {
        // Integer必须实现Comparable接口(compareTo方法)才可以加入到List
        //     compareTo实现了自己和别人的对比
        List<Integer> list = new ArrayList<>();
        list.add(1);list.add(5);list.add(3);
        System.out.println(list);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.equals(o2)) {
                    return 0;
                } else if (o1 > o2) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        System.out.println(list);
    }

    /**
     * 在Collection中有的是可以重复对象（比如ArrayList），有的不可以（比如set）
     */
    public static void testCollectionNotAllowSame () {
        String var = "123";
        Collection<String> col = new ArrayList<>(10);
        System.out.println(col.add(var));
        System.out.println(col.add(var));
        System.out.println(col);
        Iterator v = col.iterator();
        String var1 = (String) v.next();
        String var2 = (String) v.next();
        if (var1 == var2) {
            System.out.println("var1 == var2");
        } else {
            System.out.println("var1 != var2");
        }
    }
}
