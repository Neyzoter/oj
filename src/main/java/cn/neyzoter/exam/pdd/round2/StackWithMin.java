package cn.neyzoter.exam.pdd.round2;

/**
 * 使用一个单端队列实现一个包含printMin的Stack
 * 说明：
 * 要求push时间复杂度1，pop时间复杂度无要求，printMin时间复杂度1
 */
public class StackWithMin {
    private final Queue que;
    private volatile int min;
    public StackWithMin() {
        que = new Queue();
    }
    public void push(int val) {
        if (que.size() == 0) {
            min = val;
        } else {
            min = Math.min(val, min);
        }
        que.put(val);
    }
    public int pop() throws Exception {
        if (que.size() == 0) {
            throw new Exception("Empty Stack!");
        }
        int size = que.size();
        int subMin = Integer.MAX_VALUE;
        while (size-- > 1) {
            int val = que.take();
            subMin = Math.min(subMin, val);
            que.put(val);
        }
        min = subMin;
        return que.take();
    }
    public void printMin() throws Exception {
        if (que.size() == 0) {
            throw new Exception("Empty Stack!");
        }
        System.out.print(min);
    }
}

//Queue已经实现
class Queue {
    public void put(int val) {
        // 时间复杂度1
    }
    public int take() {
        //时间复杂度1
        return 0;
    }
    public int size() {
        //时间复杂度1
        return 0;
    }
}
