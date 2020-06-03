package cn.neyzoter.leetcode.algo.array;

import java.util.*;

/**
 * 18.四数之和
 * @author Neyzoter Song
 * @date 2020-2-1
 */
public class FourNumsSum {
    public static void main (String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;

        Solution1_FourNumsSum solution1_fourNumsSum = new Solution1_FourNumsSum();
        List<List<Integer>> list = solution1_fourNumsSum.fourSum(nums, target);

        System.out.println(list);
    }

    /**
     * 测试set是针对不同对象还是对象内的元素
     */
    public void testSetis4InstanceOrNums () {
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        List<Integer> list2 = new LinkedList<>();
        list2.add(1);
        list2.add(2);
        Set<List<Integer>> result = new HashSet<>();
        result.add(list1);
        result.add(list2);
        System.out.println(result);
    }
}

class Solution1_FourNumsSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Set<List<Integer>> set_result = new HashSet<>();

        if (nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i ++) {
            for (int j = i + 1 ; j < nums.length ; j ++) {
                Set<List<Integer>> set = find2Items(nums, i , j, target - nums[i] - nums[j]);
                for (List<Integer> list : set) {
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.sort(new Comparator<Integer>() {
                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    set_result.add(list);
                }
            }
        }
        for (List<Integer> list : set_result) {
            result.add(list);
        }
        return result;
    }

    /**
     * 找到两数之和为target
     * @param ascendNums 升序数组
     * @param i 不可使用的元素i下标
     * @param j 不可使用的元素j下标
     * @param target 目标数值
     * @return
     */
    public Set<List<Integer>> find2Items (int[] ascendNums, int i, int j, int target) {
        Set<List<Integer>> result = new HashSet<>();
        for (int left = 0,right = ascendNums.length - 1; left < right ;) {
            if (left == i || left == j) {
                left ++;
                continue;
            }
            if (right == i || right == j) {
                right --;
                continue;
            }
            if (ascendNums[left] + ascendNums[right] > target) {
                right --;
            } else if (ascendNums[left] + ascendNums[right] < target) {
                left ++;
            } else {
                List<Integer> list = new LinkedList<>();
                list.add(ascendNums[left]);
                list.add(ascendNums[right]);
                result.add(list);
                // 开始查找下一个
                left ++;
            }

        }
        return result;
    }
}
