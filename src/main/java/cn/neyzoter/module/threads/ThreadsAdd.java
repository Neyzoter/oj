package cn.neyzoter.module.threads;

import java.util.concurrent.Callable;

/**
 * 多线程求和
 * @author neyzoter
 */
public class ThreadsAdd {
    public static void main(String[] args) {

    }
}

class AddClass implements Callable<Long> {
    private long[] num;
    private int start;
    private int end;
    public AddClass (long[] n, int s, int e) {
        num = n;
        start = s;
        end = e;
    }
    @Override
    public Long call() throws Exception {
        long sum = 0;
        for (int i = start; i <= end; i++) {
            sum += num[i];
        }
        return sum;
    }
}
