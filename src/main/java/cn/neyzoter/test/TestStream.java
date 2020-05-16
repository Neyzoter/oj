package cn.neyzoter.test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * test Stream<br/>
 * Java 8 中的 Stream 是对集合（Collection）对象功能的增强，它专注于对集合对象进行各种非常便利、高效的聚合操作（aggregate operation），或者大批量数据操作 (bulk data operation)
 * @author Charles Song
 * @date 2020-5-16
 */
public class TestStream {
    public static void main (String[] args) {
        String[] strArray = new String[]{"a", "b", "c"};
        List<String> vid = Arrays.asList(strArray);
        Stream stream = vid.stream();
        stream = stream.map(o -> {
            String obj = (String) o;
            return obj.toUpperCase();
        });
        stream.forEach(System.out::println);
    }
}
