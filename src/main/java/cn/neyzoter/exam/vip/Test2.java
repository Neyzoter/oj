package cn.neyzoter.exam.vip;

import java.util.Random;
import java.util.Scanner;

/**
 * 快速排序实现查找第K大的数
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Sol1_Test1 sol = new Sol1_Test1();
        try {
            System.out.println(sol.kthLargestNum(nums, k));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
class Sol1_Test1 {
    /**
     * 第K大的数字
     * @param nums 乱序数组
     * @param k 第K大
     * @return 第K大的数字
     */
    public int kthLargestNum(int[] nums, int k) throws Exception {
        if (nums == null) {
            throw new Exception("Null Pointer Exception");
        }
        // 第k大就是找第length - k小
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    /**
     * 快速选择第K大的数
     * @param nums 乱序数组
     * @param l 左边界
     * @param r 右边界
     * @param idx 目标下标
     * @return 第K大的数字
     */
    private int quickSelect(int[] nums, int l, int r, int idx) {
        int q = randomPartitioner(nums, l, r);
        if (q == idx) {
            // 找到了第K大
            return nums[q];
        } else {
            // 如果q比idx小，说明需要找右侧
            // 如果q比idx大，说明需要找左侧
            return q < idx ? quickSelect(nums, q + 1, r, idx) : quickSelect(nums, l, q - 1, idx);
        }
    }
    /**
     * 随机快速排序分区
     * @param nums 乱序数组
     * @param l 左边界下标
     * @param r 右边界下标
     * @return 分割数字的下标
     */
    private int randomPartitioner(int[] nums, int l, int r) {
        // 随机找一个基准
        int idx = new Random().nextInt(r - l + 1) + l;
        // 将找到大基准拷贝到最右侧
        swap(nums, idx, r);
        return partitioner(nums, l, r);
    }
    /**
     * 快速排序分区
     * @param nums 乱序数组
     * @param l 左边界下标
     * @param r 右边界下标
     * @return 分割数字的下标
     */
    private int partitioner(int[] nums, int l, int r) {
        int x = nums[r], idx = l - 1;
        for (int i = l; i < r; i++) {
            if (nums[i] <= x) {
                swap(nums, ++idx, i);
            }
        }
        swap(nums, idx + 1, r);
        return idx + 1;
    }
    /**
     * 交换数组元素
     * @param nums 数组
     * @param x 下标x
     * @param y 下标y
     */
    private void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
