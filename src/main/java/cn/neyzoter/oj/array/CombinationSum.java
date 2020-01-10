package cn.neyzoter.oj.array;


import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39 组合总和
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates1 = {2,3,6,7};int target1 = 7;
        int[] candidates2 = {2,3,5};int target2 = 8;
        int[] candidates3 = {};int target3 = 0;
        Solution1_CombinationSum solution1_combinationSum = new Solution1_CombinationSum();
        System.out.println(solution1_combinationSum.combinationSum(candidates1, target1));
        System.out.println(solution1_combinationSum.combinationSum(candidates2, target2));
        System.out.println(solution1_combinationSum.combinationSum(candidates3, target3));
    }
}

/**
 * 递归法
 */
class Solution1_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return find(candidates, target,0);

    }
    public List<List<Integer>> find (int[] candidates, int target, int idx) {
        List<List<Integer>> list = new LinkedList<>();
        for (int i = idx ; i < candidates.length && candidates[i] <= target; i ++) {
            if (candidates[i] == target) {
                List<Integer> l_temp = new LinkedList<>();
                l_temp.add(candidates[i]);
                list.add(l_temp);
            } else {
                List<List<Integer>> l_temps = find(candidates, target - candidates[i], i);
                if (!l_temps.isEmpty()) {
                    for (List<Integer> l_temp : l_temps) {
                        l_temp.add(0,candidates[i]);
                        list.add(l_temp);
                    }
                }
            }
        }
        return list;
    }
}