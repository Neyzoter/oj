package cn.neyzoter.oj.array;

import java.util.*;

/**
 * 46. 全排列
 * @author Neyzoter Song
 * @date 2020-2-10
 */
public class Permute {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int[] nums2 = {};
        ArrayList<int[]> nums_list = new ArrayList<>();
        nums_list.add(nums1);nums_list.add(nums2);
        Solution1_Permute solution1_permute = new Solution1_Permute();
        Solution2_Permute solution2_permute = new Solution2_Permute();
        Iterator<int[]> iter = nums_list.iterator();
        while (iter.hasNext()) {
            System.out.println(solution2_permute.permute(iter.next()));
        }
    }
}

/**
 * solution1
 */
class Solution1_Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        } else if (nums.length == 1) {
            List<Integer> list = new LinkedList<>();
            list.add(nums[0]);
            result.add(0, list);
            return result;
        }
        for (int i = 0; i < nums.length ; i ++ ) {
            int[] new_nums = new int[nums.length - 1];
            for (int j = 0,x = 0 ; x < nums.length ; x ++) {
                if (x != i) {
                    new_nums[j] = nums[x];
                    j ++;
                }
            }
            List<List<Integer>> result_temps = permute(new_nums);
            for (List<Integer> result_temp : result_temps) {
                result_temp.add(0,nums[i]);
                result.add(result_temp);
            }
        }
        return result;
    }
}

/**
 * optimize solution1
 */
class Solution2_Permute {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        for (int i = 0 ; i < nums.length ; i ++) {
            used[i] = false;
        }
        return permute(nums, used);
    }
    public List<List<Integer>> permute(int[] nums, boolean[] used) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length ; i ++ ) {
            if (used[i] == true) {
                continue;
            } else {
                used[i] = true;
            }
            List<List<Integer>> result_temps = permute(nums,used);
            if (result_temps.size() == 0) {
                List<Integer> list = new LinkedList<>();
                list.add(0,nums[i]);
                result.add(list);
            }
            for (List<Integer> result_temp : result_temps) {
                result_temp.add(0,nums[i]);
                result.add(result_temp);
            }
            used[i] = false;
        }
        return result;
    }
}