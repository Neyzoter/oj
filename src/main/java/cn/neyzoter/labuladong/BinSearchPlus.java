package cn.neyzoter.labuladong;

/**
 * 二分查找的拓展
 * @author neyzoter
 */
public class BinSearchPlus {
    public static void main(String[] args) {
        BinSearchPlus bs = new BinSearchPlus();
        int[] nums = {1, 3, 5, 7, 9};
        System.out.println(bs.firstBig(nums, 4));
    }
    /**
     * 找到左侧target下标
     * @param nums 有序数组
     * @param target 目标
     * @return 最左侧target下标
     */
    int left_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] == target) {
            // 别返回，锁定左侧边界
            right = mid - 1; }
        }
        // 最后要检查 left 越界的情况
        if (left >= nums.length || nums[left] != target)
            return -1;
        return left;
    }

    /**
     * 找到右侧target下标
     * @param nums 有序数组
     * @param target 目标
     * @return 最右侧target下标
     */
    int right_bound(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2; if (nums[mid] < target) {
            left = mid + 1;
        } else if (nums[mid] > target) {
            right = mid - 1;
        } else if (nums[mid] == target) {
            // 别返回，锁定右侧边界
            left = mid + 1;
        }
        }
        // 最后要检查 right 越界的情况
        if (right < 0 || nums[right] != target)
            return -1;
        return right;
    }

    /**
     * 找到比target大的第一个数字下标
     * @param nums 有序数组
     * @param target 目标
     * @return 比target大的第一个数字下标
     */
    int firstBig(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
