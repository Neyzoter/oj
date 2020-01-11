package cn.neyzoter.oj.array;


import sun.util.resources.cldr.zh.CalendarData_zh_Hans_HK;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 39 组合总和
 */
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates1 = {2,3,6,7};int target1 = 7;
        int[] candidates2 = {2,3,5};int target2 = 8;
        int[] candidates3 = {};int target3 = 0;
//        Solution1_CombinationSum solution1_combinationSum = new Solution1_CombinationSum();
//        System.out.println(solution1_combinationSum.combinationSum(candidates1, target1));
//        System.out.println(solution1_combinationSum.combinationSum(candidates2, target2));
//        System.out.println(solution1_combinationSum.combinationSum(candidates3, target3));

        Solution2_CombinationSum solution2_combinationSum = new Solution2_CombinationSum();
        System.out.println(solution2_combinationSum.combinationSum(candidates1, target1));
        System.out.println(solution2_combinationSum.combinationSum(candidates2, target2));
        System.out.println(solution2_combinationSum.combinationSum(candidates3, target3));
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

/**
 * 动态规划法
 */
class Solution2_CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return new LinkedList<>();
        }
        Map<Integer,List<List<Integer>>> dp = new HashMap<>();
        Arrays.sort(candidates);
        for (int num = candidates[0] ; num <= target; num ++) {
            List<List<Integer>> lists = new LinkedList<>();
            Set<List<Integer>> mapLists = new HashSet<>();
            for (int j = 0 ; j < len && candidates[j] <= num ; j ++) {
                if (dp.containsKey(num - candidates[j])) {
                    List<List<Integer>> l_dp = dp.get(num - candidates[j]);
                    for (List<Integer> l : l_dp) {
                        List<Integer> l_new = new LinkedList<>(l);
                        if (l_new.get(l_new.size() - 1) < candidates[j]) {
                            l_new.add(candidates[j]);
                        } else {
                            for (int i = 0 ; i < l_new.size() ; i ++) {
                                if (l_new.get(i) >= candidates[j]) {
                                    l_new.add(i, candidates[j]);
                                    break;
                                }
                            }
                        }
                        mapLists.add(l_new);
                    }
                }else if (candidates[j] == num) {
                    List<Integer> l_new = new LinkedList<>();
                    l_new.add(candidates[j]);
                    mapLists.add(l_new);
                }
            }
            for (List<Integer> list : mapLists) {
                lists.add(list);
            }
            dp.put(num, lists);
        }
        if (dp.containsKey(target)) {
            return dp.get(target);
        } else {
            return new LinkedList<>();
        }
    }
}
