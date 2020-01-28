package cn.neyzoter.oj.array;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author Neyzoter Song
 * @date 2020-1-28
 */
public class SearchTargetInIncrement {
    public static void main (String[] args) {
        int[] nums1 = {5,7,7,8,8,10};
        int target1 = 8;
        int[] nums2 = {5,7,7,8,8,10};
        int target2 = 6;
        int[] nums3 = {};
        int target3 = 6;
        Solution1_SearchTargetInIncrement solution1_searchTargetInIncrement = new Solution1_SearchTargetInIncrement();
        int[] result = solution1_searchTargetInIncrement.searchRange(nums1,target1);
        System.out.println(String.format("nums1 : left = %d, right = %d",result[0], result[1]));
        result = solution1_searchTargetInIncrement.searchRange(nums2,target2);
        System.out.println(String.format("nums2 : left = %d, right = %d",result[0], result[1]));
        result = solution1_searchTargetInIncrement.searchRange(nums3,target3);
        System.out.println(String.format("nums2 : left = %d, right = %d",result[0], result[1]));
    }

}

class Solution1_SearchTargetInIncrement {
    public int[] searchRange(int[] nums, int target) {
        int[] index = {-1,-1};
        int len = nums.length;
        int left = 0;int right = len - 1;
        int middle = -1;
        // 找到其中一个target
        for (int i  ; left <= right ;) {
            i = (left + right) / 2;
            if (target == nums[i]) {
                middle = i;
                break;
            } else if (target < nums[i]) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }
        if (middle != -1) {
            // 搜索最左侧和最右侧的下标
            for (left = middle ;left > 0; ) {
                if (nums[left-1] == target) {
                    left --;
                } else {
                    break;
                }
            }
            for (right = middle;right < len - 1; ) {
                if (nums[right+1] == target) {
                    right ++;
                } else {
                    break;
                }
            }
            index[0] = left;
            index[1] = right;
        }
        return index;
    }
}
