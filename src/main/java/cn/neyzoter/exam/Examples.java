package cn.neyzoter.exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

/**
 * 常用数据结构
 */
public class Examples {
    public static void main(String[] args) {
        map();
    }

    public static void map() {
        Map<Integer, Integer> map = new HashMap<>();
        // 添加
        map.put(1, 4);map.put(2, 8);
        map.put(3, 9);map.put(4, 10);
        // 添加所有
        Map<Integer, Integer> m = new HashMap<>();
        m.put(10, 4);m.put(11 , 5);
        map.putAll(m);
        // 获取
        map.get(1);
        // 获取key对应的val，如果没有则返回默认值
        map.getOrDefault(1, 3);
        // 移除
        map.remove(1);
        // 遍历
        Set<Map.Entry<Integer, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entrySet) {
            System.out.println("Key " + entry.getKey());
            System.out.println("Value " + entry.getValue());
        }
        Set<Integer> keySet = map.keySet();
        for (int key : keySet) {
            System.out.println("Key " + key);
            System.out.println("Value " + map.get(key));
        }
        // forEach 遍历
        map.forEach(new BiConsumer<Integer, Integer>() {
            @Override
            public void accept(Integer key, Integer val) {
                System.out.println("Key " + key);
                System.out.println("Value " + map.get(val));
            }
        });
        // 清除所有数据
        map.clear();
        System.out.println("After clear, map size : " + map.size());
    }
}
