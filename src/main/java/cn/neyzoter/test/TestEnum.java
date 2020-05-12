package cn.neyzoter.test;

import org.apache.commons.lang3.StringUtils;

/**
 * 测试Enum
 * @author Charles Song
 * @date 2020-5-12
 */
public class TestEnum {
    public static void main (String[] args) {
        System.out.println(Week.FRIDAY);
        System.out.println(Week.FRIDAY.getDay());
        System.out.println(StringUtils.contains("12saturday12", Week.SATURDAY.getDay()) ? "\"12saturday12\" contains " + Week.SATURDAY.getDay() : "\"12saturday12\" does not contains \"" + Week.SATURDAY.getDay() + "\"");

    }
}

/**
 * 星期
 * @author Charles Song
 * @date 2020-5-12
 */
enum Week {
    /**
     * 周一到周日
     */
    MONDAY("monday"),
    TUESDAY("tuesday"),
    WEDNESDAY("wednesday"),
    THURSDAY("thursday"),
    FRIDAY("friday"),
    SATURDAY("saturday"),
    SUNDAY("sunday");

    private final String day;

    Week (String day) {
        this.day = day;
    }

    public String getDay () {
        return this.day;
    }
}
