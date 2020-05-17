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
    public static int STR_NUM = 10000000;
    public static int THREAD_NUM = 8;
    public static void main (String[] args) {
        testSpliterator();
    }
    public static void testSpliterator () {
        Collection<String> col = new HashSet<>(10000);
        for (int i = 0; i < STR_NUM; i ++) {
            col.add(i + "x" + (i + 2));
        }
        Spliterator<String> spliterator = col.spliterator();

        class Task implements Runnable {
            private int runtime = 0;
            @Override
            public void run () {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName + " running ...");
                spliterator.trySplit().forEachRemaining(o -> {
                    String str = o;
                    str.toUpperCase();
                    runtime++;
                });
                System.out.println(threadName + " runtime : " + runtime);
            }
        }

        for (int i = 0; i < THREAD_NUM; i ++) {
            new Thread(new Task()).start();
        }
    }
}
