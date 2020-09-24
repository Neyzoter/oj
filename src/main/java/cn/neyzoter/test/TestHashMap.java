package cn.neyzoter.test;

import java.util.HashMap;

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
        map.put(null, 1);
        System.out.println(map.get(null));
    }
}
