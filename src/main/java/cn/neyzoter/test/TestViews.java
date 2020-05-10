package cn.neyzoter.test;

import java.util.*;

/**
 * 测试视图Views的应用<br/>
 * 比如keySet返回一个实现Set接口的类对象，这个类的方法对原映射进行操作
 * @author Charles Song
 * @date 2020-5-10
 */
public class TestViews {
    public static void main (String[] args) {
        System.out.println("====  testLightCollectionWrapper  ====");
        testLightCollectionWrapper();
        System.out.println("====  testSubRange  ====");
        testSubRange();
        System.out.println("====  testUnmodifiableViews  ====");
        testUnmodifiableViews();
        System.out.println("====  testSyncMap  ====");
        testSyncMap();
    }

    /**
     * 轻量级集合包装器
     */
    public static void testLightCollectionWrapper (){
        Integer[] nums = {1,2,3,4,5,6,7,8,9};
        /**
         * 返回的不是ArrayList而是视图对象<br/>
         * 带有访问底层数组的get和set方法，但是不能改变数组的大小（add、remove等）
         * */
        List<Integer> numList = Arrays.asList(nums);

        // 原始
        for (int i = 0; i < numList.size(); i ++) {
            System.out.print(numList.get(i) + "  ");
            numList.set(i, numList.get(i) + i);
        }
        System.out.println();System.out.println();

        // 更改后
        for (int num : nums) {
            System.out.print(num + "  ");
        }
        System.out.println();System.out.println();

        // 改变数组大小不允许
        System.out.println("视图不支持更改数组的大小");
        try {
            numList.remove(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testSubRange () {
        List<Integer> staff = new ArrayList<>();
        staff.add(1);
        staff.add(2);
        staff.add(3);
        staff.add(4);
        staff.add(5);
        staff.add(6);
        // 获取子范围视图
        List sub = staff.subList(2, 5);
        sub.set(1, 9);
        staff.listIterator().forEachRemaining(System.out::println);

        /**
         * 字符串的substring返回的不是视图
         */
        String str = "12345678";
        String substr = str.substring(1, 5);
        substr.replace('4', '9');
        System.out.println(str);

        /**
         * SortedSet < E > subSet ( E from , E to)
         * SortedSet < E > headSet ( E to)
         * SortedSet < E > tail Set ( E from)
         */

        /**
         * SortedMap < K , V > subMap ( K from , K to)
         * SortedMap < K , V > headMap (K to)
         * So 「 tedMap < K , V > tail Map ( K from)
         */

        /**
         * NavigableSet < E > subSet ( E from , boolean fromlnclusive , E to , boolean tolnclusive)
         * NavigableSet < E > headSet ( E to , boolean tolnclusive)
         * Navigab1 eSet < E > tail Set ( E from , boolean fromlnclusive)
         */

    }

    /**
     * 不可更改的视图
     */
    public static void testUnmodifiableViews () {
        Collection<String> col = new ArrayList<>();
        col.add("123");
        col.add("234");
        col.add("456");
        col.add("678");
        // 获取一个不可更改的视图
        Collection<String> unmodCol = Collections.unmodifiableCollection(col);
        unmodCol.iterator().forEachRemaining(System.out::println);

        /**
         * 不能更改
         */
        try {
            unmodCol.add("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 同步视图
     */
    public static void testSyncMap () {
        HashMap<String, String> hashMap = new HashMap<>(10);
        hashMap.put("1","Allen");
        hashMap.put("2","Amy");
        hashMap.put("3","Mike");
        Map<String, String> map = Collections.synchronizedMap(hashMap);
        map.entrySet().iterator().forEachRemaining(System.out::println);
        map.put("4", "Jack");
        map.entrySet().iterator().forEachRemaining(System.out::println);
    }
}
