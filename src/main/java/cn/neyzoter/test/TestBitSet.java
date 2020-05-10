package cn.neyzoter.test;

import java.util.BitSet;

/**
 * 测试位集
 * @author Charles Song
 * @date 2020-5-10
 */
public class TestBitSet {
    public static void main (String[] args) {
        BitSet set1 = new BitSet(5);
        set1.set(3);set1.set(4);set1.set(2);
        BitSet set2 = new BitSet(5);
        set2.set(1);set2.set(0);set2.set(2);
        set1.xor(set2);

        for (int i = 0 ; i < set1.length(); i ++) {
            System.out.println(set1.get(i));
        }
    }
}
