package cn.neyzoter.test;

import java.util.WeakHashMap;

/**
 * 测试WeakHashMap
 * @author Charles Song
 * @date 2020-5-9
 */
public class TestWeakHashMap {
    // TODO
    public static void main (String[] args) {
        WeakHashMap<String, Integer> map = new WeakHashMap<>();
        map.put("charles",10);map.put("nick",7);map.put("jack",8);map.put("bill",10);

        for (int i = 10; i > 0 ;i --) {
            System.out.println(i);
        }
    }
}
