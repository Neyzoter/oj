package cn.neyzoter.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 测试HashMap的异常
 * @author neyzoter
 */
public class TestConcurrentModificationException4EntrySet {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(1, 2);hm.put(2, 3);hm.put(3,4);
        Set<Map.Entry<Integer, Integer>> set = hm.entrySet();
        // 不可以一边遍历一边删除
//        for (Map.Entry<Integer, Integer> e : set) {
//            System.out.println(e.getKey() + " " + e.getValue());
//            if (e.getValue() == 3) {
//                hm.remove(e.getKey());
//            }
//        }
        // 可以一边遍历，一边更改
        for (Map.Entry<Integer, Integer> e : set) {
            if (e.getValue() == 3) {
                hm.replace(e.getKey(), 5);
            }
            System.out.println(e.getKey() + " " + e.getValue());
        }
    }
}
