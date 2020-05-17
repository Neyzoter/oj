package cn.neyzoter.test;

/**
 * 测试ThreadLocal
 * @author Charles Song
 * @date 2020-5-9
 */
public class TestThreadLocal {
    public static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>() {
        @Override
        public Integer initialValue () {
            return 0;
        }
    };
    public static ThreadLocal<Double> threadLocalD = new ThreadLocal<Double>() {
        @Override
        public Double initialValue () {
            return 0.0;
        }
    };
    public static void main (String[] args) {
        for (int i = 0; i < 3; i ++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    addInt();
                }
            };
            t.start();
        }
    }
    public static void addInt () {
        for (int i = 0; i < 5; i ++) {
            Integer n = threadLocal.get();
            n += 1;
            threadLocal.set(n);
            Double d = threadLocalD.get();
            d += 2.0;
            threadLocalD.set(d);
            System.out.println(Thread.currentThread().getName() + " : threadLocal = " + threadLocal.get());
            System.out.println(Thread.currentThread().getName() + " : threadLocalD = " + threadLocalD.get());
        }
    }
}
