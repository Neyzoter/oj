package cn.neyzoter.leetcode.algo.array;

/**
 * 704. 二分查找
 * @author Charles Song
 * @date 2020-5-26
 */
public class BinarySearch {
    public static void main (String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        Solution1_BinarySearch binarySearch = new Solution1_BinarySearch();
        System.out.println(binarySearch.search(nums, target));
    }
}

class Solution1_BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}
