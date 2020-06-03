package cn.neyzoter.leetcode.algo.array;

/**
 * 33. 搜索旋转排序数组
 */
public class SearchTranposedSortedArray {
    public static void main(String[] args) {
        Solution1_SearchTranposedSortedArray solution1_searchTranposedSortedArray = new Solution1_SearchTranposedSortedArray();
        int[] nums = {4,5,1,2,3};
        int[] targets = {0,3,5,2,4,1};
        for (int target : targets) {
            System.out.println(String.format("target = %d idx = %d",target,solution1_searchTranposedSortedArray.search(nums, target)));
        }
    }
}

/**
 * 有问题
 */
class Solution1_SearchTranposedSortedArray {
    /**
     * 二分查找
     * @param left
     * @param right
     * @param nums
     * @param target
     * @return
     */
    public int binarysearch(int left, int right, int[] nums, int target) {
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] > target) {
                right = middle - 1;
            }else if (nums[middle] < target){
                left = middle + 1;
            }else {
                return middle;
            }
        }
        return -1;
    }

    /**
     * 查找旋转的索引
     * @param nums
     * @return
     */
    public int find_rotation_idx (int[] nums) {
        int left = 0;int right = nums.length - 1;
        if (nums[left] < nums[right]) {
            return 0;
        }
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[middle + 1]) {
                return middle + 1;
            } else if (nums[middle] >= nums[0]){
                left = middle + 1;
            } else if (nums[middle] <= nums[nums.length - 1]) {
                right = middle - 1;
            }
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target ? 0:-1;
        } else if (nums.length == 0) {
            return -1;
        }
        int rotation_idx = find_rotation_idx(nums);
        if (rotation_idx == -1) {
            return -1;
        }
        if (rotation_idx == 0) {
            return binarysearch(0, nums.length-1, nums, target);
        } else if (target >= nums[0]) {
            return binarysearch(0, rotation_idx - 1, nums, target);
        } else if (target <= nums[nums.length - 1]){
            return binarysearch(rotation_idx, nums.length - 1, nums, target);
        } else {
            return -1;
        }
    }
}
