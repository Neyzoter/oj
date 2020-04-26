package cn.neyzoter.test;

/**
 * 测试接口中的变量定义
 * @author Charles Song
 * @date 2020-4-20
 */
public interface TestIfVar {
    /**
     * 必须且默认是public static final的
     */
    public int val1 = 1;
    public static int val2 = 2;
    public final int val3 = 3;
    public static final int val4 = 4;

    /**
     * 错误
     */
//    private int val5 = 5;

    /**
     * 打印
     */
    void print () ;

    /**
     * 实现方法
     * @return String
     */
    default String getIfName () {
        return "TestIfVal";
    }
}

class IfImpl implements TestIfVar {
    @Override
    public void print () {
        System.out.println(val1 + " " + val2 + " " + val3 + " " + val4);
    }
}