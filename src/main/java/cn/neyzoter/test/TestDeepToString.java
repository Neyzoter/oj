package cn.neyzoter.test;

import java.util.Arrays;
/**
 * 测试deepToString
 * @author Charles Song
 * @date 2020-5-12
 */
public class TestDeepToString {
    public static void main (String[] args) {
        Integer[] var = new Integer[10];
        for (Integer i = 0; i < 10; i ++) {
            var[i] = i;
        }
        System.out.println(Arrays.deepToString(var));
    }
}
