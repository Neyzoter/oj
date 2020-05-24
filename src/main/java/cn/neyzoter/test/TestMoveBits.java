package cn.neyzoter.test;

/**
 * 按位移测试
 * @author Charles Song
 * @date 2020-5-24
 */
public class TestMoveBits {
    public static void main (String[] args) {
        testRRRight();
        testRRight();
    }

    /**
     * >>>测试<br/>
     * 逻辑右移<br/>
     * 忽略最高位是正负标识，作为数值位使用
     */
    public static void testRRRight () {
        int neg = -3;
        neg = neg >>> 1;
        System.out.println("-3 >>> 1 = " + neg);
        int pos = -3;
        pos = pos >> 1;
        System.out.println("3 >>> 1 = " + pos);
    }

    /**
     * >><br/>
     * 算术右移
     */
    public static void testRRight () {
        int neg = -3;
        neg = neg >> 1;
        System.out.println("-3 >> 1 = " + neg);
        int pos = 3;
        pos = pos >> 1;
        System.out.println("3 >> 1 = " + pos);

    }

}
