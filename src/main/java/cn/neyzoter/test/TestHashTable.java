package cn.neyzoter.test;

import java.util.Hashtable;

/**
 * 测试HashTable
 * @author neyzoter
 */
public class TestHashTable {
    public static void main(String[] args) {
        // HashTable通过synchronized来实现上锁
        Hashtable<Integer, Integer> hashtable = new Hashtable<>();
        hashtable.put(1, 1);
    }
}
