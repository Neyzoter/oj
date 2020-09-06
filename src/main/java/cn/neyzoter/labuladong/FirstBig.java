package cn.neyzoter.labuladong;

/**
 * 找到第一个比目标大的数的下标
 * @author neyzoter
 */
public class FirstBig {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3, 4, 4, 5};
        int idx = firstBig(nums, 4);
        System.out.println(idx);
    }
    public static int firstBig(int[] sortedNums, int target) {
        int left = 0, right =sortedNums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (sortedNums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
