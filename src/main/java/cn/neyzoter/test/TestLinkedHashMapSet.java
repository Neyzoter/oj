package cn.neyzoter.test;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * 测试链接散列映射和链接散列集
 * @author Charles Song
 * @date 2020-5-10
 */
public class TestLinkedHashMapSet {
    public static void main (String[] args) {
        System.out.println("====== testLinkedHashMap ======");
        testLinkedHashMap();
        System.out.println("====== testLinkedHashSet ======");
        testLinkedHashSet();
    }

    /**
     * 测试LinkedHashMap<br/>
     * LinkedHashMap可以记录插入顺序或者访问顺序
     */
    public static void testLinkedHashMap () {
        /**
         * accessOrder : the ordering mode - true for access-order, false for insertion-orde<br/>
         * true : 根据访问顺序来进行排序<br/>
         * false: 根据插入顺序进行排序
         */
        LinkedHashMap<String, String> map = new LinkedHashMap<String, String>(16, 0.75F, true){
            /**
             * 如果超过5个，则将数据删除，每次插入都会调用该函数
             * @param eldest 最老的
             * @return 是否删除
             */
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, String> eldest){
                System.out.println("[eldest entry] " + eldest.getKey() + "  " + eldest.getValue());
                boolean remove = size() > 5;
                System.out.println("[remove ? ] " + remove);
                return remove;
            }
        };
        map.put("1","Amy");
        map.put("2","Allen");
        map.put("3","Jack");
        map.put("4","Ma");
        map.get("1");map.get("2");
        map.put("5","Pony");
        map.put("6","Pick");
        map.forEach((k, v) -> System.out.println(k +"  " + v));System.out.println();

        map.get("3");
        map.forEach((k, v) -> System.out.println(k +"  " + v));System.out.println();
    }

    /**
     * 测试LinkedHashSet<br/>
     * LinkedHashSet记录插入顺序
     */
    public static void testLinkedHashSet () {
        LinkedHashSet<String> set = new LinkedHashSet<>(16,0.75F);
        set.add("1");
        set.add("2");
        set.add("3");
        set.add("4");
        set.iterator().forEachRemaining(System.out::println);System.out.println();
        set.contains("3");
        set.iterator().forEachRemaining(System.out::println);System.out.println();
    }
}
