package cn.neyzoter.test;

/**
 * 测试Double类型
 * @author neyzoter
 */
public class TestDouble {
    public static void main(String[] args) {
        double d = 33.0000000000000000000000000000000000001;
        long i = (long) d;
        System.out.println(i);
    }
}
