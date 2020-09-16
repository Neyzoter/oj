package cn.neyzoter.leetcode.algo.array;

import java.util.PriorityQueue;

/**
 * @author neyzoter
 */
public class _215_KthNum {
    public static void main(String[] args) {

    }
}

/**
 * 堆排序
 * 时间复杂度 O(nlogn)
 */
class Sol1_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k > nums.length / 2 ? (o1, o2) -> o1 - o2 : (o1, o2) -> o2 - o1);
        for (int n : nums) {
            pq.add(n);
        }
        int kth = k > nums.length / 2 ? nums.length - k + 1 : k;
        for (int i = 0; i < kth - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
}

/**
 * 冒泡排序
 * 时间复杂度O(min(n * k, n * (n - k)))
 */
class Sol2_FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        // 降序还是升序
        boolean desc = desc(nums, k);
        int kth = desc ? k : nums.length - k + 1;
        for (int i = 0; i < kth; i++) {
            for (int j = 1; j < nums.length - i; j++) {
                if ((desc && nums[j] < nums[j - 1]) || !desc && nums[j] > nums[j - 1]) {
                    int temp = nums[j - 1];
                    nums[j - 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
        return nums[nums.length - kth];
    }

    /**
     * 降序
     * @param nums 数组
     * @param k 第k大的数字
     * @return 是否降序
     */
    public static boolean desc(int[] nums, int k) {
        return k < nums.length / 2;
    }

}