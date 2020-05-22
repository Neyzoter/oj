package cn.neyzoter.test.collection.queue;

import cn.neyzoter.module.util.TimeUtil;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * 测试Queue
 * @author Charles Song
 * @date 2020-5-22
 */
public class TestQueue {
    public static void main (String[] args) {
        testDelayQueue();
    }

    public static void testDelayQueue() {
        DelayQueue<DelayString> queue = new DelayQueue<>();
        queue.add(new DelayString("1bc", 4, TimeUnit.SECONDS));
        while (true) {
            DelayString str = queue.poll();
            if (str == null) {
                System.out.println("Get null from queue");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            } else {
                System.out.println(str.toString());
                break;
            }
        }
    }
}

class DelayString implements Delayed {
    private long time;
    public String str;
    DelayString (String str, long time, TimeUnit unit) {
        this.str = str;
        this.time = System.currentTimeMillis() + (time > 0 ? unit.toMillis(time) : 0);
    }
    @Override
    public long getDelay(TimeUnit unit) {
        return this.time - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        DelayString oStr = (DelayString) o;
        long diff = this.time - oStr.time;
        if (diff <= 0) {// 改成>=会造成问题
            return -1;
        }else {
            return 1;
        }
    }

    @Override
    public String toString () {
        return this.str;
    }
}
