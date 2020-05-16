package cn.neyzoter.test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Spliterator;

/**
 * 测试Collection的Spliterator
 * @author Charles Song
 * @date 2020-5-6
 */
public class TestSpliteratorCollection {
    public static void main (String[] args) {
        testSpliterator();
    }
    public static void testSpliterator () {
        Collection<String> col = new HashSet<>(10000);
        for (int i = 0; i < 100; i ++) {
            col.add(i + "x" + (i + 2));
        }
        Spliterator<String> spliterator = col.spliterator();



        class MyThread extends Thread {
            @Override
            public void run () {
                String threadName = this.getName();
                System.out.println(threadName + " running ...");
                spliterator.trySplit().forEachRemaining(o -> {
                    String str = o;
                    str.toUpperCase();
                });
            }
        }

    }
}
