package cn.neyzoter.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 测试集合
 * @author Charles Song
 * @date 2020-4-19
 */
public class TestCollection {
    public static void main (String[] args) {
        testCollecionRm();
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
}
