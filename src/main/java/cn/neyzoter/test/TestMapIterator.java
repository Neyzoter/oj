package cn.neyzoter.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 测试Map的迭代器
 * @author neyzoter
 */
public class TestMapIterator {
    public static void main(String[] args) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 1000000; i ++) {
            map.put(i, i);
        }
        long startTime = System.currentTimeMillis();
        Set<Integer> key = map.keySet();
        for (Integer k : key ) {
            int v = map.get(k);
            assert k == v;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("keySet time : " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        Set<Map.Entry<Integer, Integer>> entry = map.entrySet();
        for (Map.Entry<Integer, Integer> e : entry) {
            assert (int)e.getKey() == e.getValue();
        }
        endTime = System.currentTimeMillis();
        System.out.println("entrySet time : " + (endTime - startTime));
    }
}
