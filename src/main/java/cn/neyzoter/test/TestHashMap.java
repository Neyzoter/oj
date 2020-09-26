package cn.neyzoter.test;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 测试HashMap
 * @author Charles Song
 * @date 2020-6-21
 */
public class TestHashMap {
    /**
     * 注意：需要重写hash code和equals
     */
    class People {
        int age;
        public People (int a) {
            this.age = a;
        }
        @Override
        public int hashCode () {
            return age;
        }
        public boolean equals (People p) {
            return this.age == p.age;
        }
    }
    public static void main (String[] args) {
        HashMap<People, Integer> map = new HashMap<>();
        System.out.println("contains null ? " + map.containsKey(null));
        System.out.println(map.get(null));
        map.put(null, 1);
        System.out.println("contains null ? " + map.containsKey(null));
        System.out.println(map.get(null));
        String str = "123";
        System.out.println(str.substring(1) + str.substring(str.length() - 1));
        /**
         * ConcurrentHashMap 的KV都不是NULL
         */
        ConcurrentHashMap<People, Integer> chm = new ConcurrentHashMap<>();
        chm.put(null, 1);
    }

}
