package cn.neyzoter.test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试随机数
 * @author neyzoter
 */
public class TestRandom {
    public static void main(String[] args) {
        Random r1 = new Random(1);
        Lock lock = new ReentrantLock();
        Random r2 = new Random(1);
        /**
         * 如何种子相同，则生成相同次数后，生成数字相同
         */
        System.out.println("r1 : " + r1.nextInt(10));
        System.out.println("r2 : " + r2.nextInt(10));
        System.out.println("r1 : " + r1.nextInt(10));
        System.out.println("r2 : " + r2.nextInt(10));
        System.out.println("r2 : " + r2.nextInt(10));
        System.out.println("r2 : " + r2.nextInt(10));
        System.out.println("r1 : " + r1.nextInt(10));

    }
}
