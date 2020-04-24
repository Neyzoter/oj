package cn.neyzoter.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

/**
 * 测试集合
 * @author Charles Song
 * @date 2020-4-19
 */
public class TestCollection {
    public static void main (String[] args) {
        testCollecionRm();
        testCompare();
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
}
