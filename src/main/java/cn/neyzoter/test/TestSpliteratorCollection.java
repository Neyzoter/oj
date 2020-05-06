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
        for (int i = 0; i < 7000; i ++) {
            col.add(i + "x" + (i + 2));
        }
        Spliterator<String> spliterator = col.spliterator();
        // 如果spliterator还有数据没有处理，则不断处理
        int i = 0;
        for (;spliterator.estimateSize() > 0;) {
            // 按照顺序处理，类似Iterator
            // System.out::println作为Consumer
            i++;
//            System.out.print(i++ + " spliterator ");
            spliterator.tryAdvance(System.out::println);
        }
    }
}
