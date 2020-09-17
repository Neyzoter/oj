package cn.neyzoter.module.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

/**
 * 测试布隆过滤器
 * @author neyzoter
 */
public class TestBloom {
    public static final int size = 1000000;
    public static final int half = 500000;
    public static void main(String[] args) {
        BloomFilter<Integer> bf = BloomFilter.create(Funnels.integerFunnel(), size);
        for (int i = 0; i < half; i++) {
            bf.put(i);
        }
        int error = 0;
        for (int i = half + 1; i < 2 * half; i++) {
            if (bf.mightContain(i)) {
                error++;
            }
        }
        System.out.println("Not Contain Error : " + error + " error rate : " + (double) error / half);

        error = 0;
        for (int i = 0; i < half; i++) {
            if (!bf.mightContain(i)) {
                error++;
            }
        }
        System.out.println("Contain Error : " + error + " error rate : " + (double) error / half);

    }
}