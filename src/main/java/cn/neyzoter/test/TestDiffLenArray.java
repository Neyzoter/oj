package cn.neyzoter.test;

import java.util.Arrays;

/**
 * 测试不同长度的数组
 * @author Charles Song
 * @date 2020-5-12
 */
public class TestDiffLenArray {
    public static void main (String[] args) {
        Integer[][] diffLenArray = new Integer[5][];
        for (int i = 0; i < 5; i ++) {
            diffLenArray[i] = new Integer[i];
            for (int j = 0; j < diffLenArray[i].length; j ++) {
                diffLenArray[i][j] = j;
            }
        }
        System.out.println(Arrays.deepToString(diffLenArray));
    }
}
