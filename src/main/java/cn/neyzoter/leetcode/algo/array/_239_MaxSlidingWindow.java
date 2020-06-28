package cn.neyzoter.leetcode.algo.array;

import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 239. 滑动窗口最大值
 * @author Charles Song
 * @date 2020-6-27
 */
public class _239_MaxSlidingWindow {
    public static void main (String[] args) {

    }
}

class Sol1_239_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonotonousQueue queue = new MonotonousQueue(k);
        int[] max = new int[nums.length + 1 - k];
        for (int i = 0; i < k; i ++) {
            queue.add(nums[i]);
        }
        max[0] = queue.max();
        for (int i = k; i < nums.length; i ++) {
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            max[i - k + 1] = queue.max();
        }
        return max;
    }
}

/**
 * 单调队列
 */
class MonotonousQueue {
    private ArrayDeque<Integer> q;

    public MonotonousQueue (int k) {
        q = new ArrayDeque<>(k);
    }

    public void add (int e) {

        for (;q.size() != 0 && q.getLast() < e;) {
            q.removeLast();
        }
        q.addLast(e);
    }

    public void remove (int e) {
        if (q.size() != 0 && q.getFirst() == e) {
            q.removeFirst();
        }
    }

    public int max () {
        return q.getFirst();
    }
}