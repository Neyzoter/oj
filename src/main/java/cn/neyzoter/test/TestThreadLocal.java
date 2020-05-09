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
            System.out.println(Thread.currentThread().getName() + " : num = " + threadLocal.get());
        }
    }
}
