package cn.neyzoter.test;

import java.util.EnumSet;

/**
 * 测试EnumSet
 * @author Charles Song
 * @date 2020-5-10
 */
public class TestEnumSet {
    public static void main (String[] args) {
        EnumSet<Weekday> always = EnumSet.allOf(Weekday.class);
        EnumSet<Weekday> none = EnumSet.noneOf(Weekday.class);
        /**
         * 从周一到周五
         */
        EnumSet<Weekday> workday = EnumSet.range(Weekday.MONDAY, Weekday.FRIDAY);
        always.iterator().forEachRemaining(System.out::println);System.out.println();
        none.iterator().forEachRemaining(System.out::println);System.out.println();
        workday.iterator().forEachRemaining(System.out::println);System.out.println();
    }
}

/**
 * weekday
 * @author Charles Song
 * @date 2020-5-10
 */
enum Weekday {
    /**
     * 周一～周日
     */
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY};