package cn.neyzoter.leetcode.algo.array;


import java.util.*;

/**
 * 491. 递增子序列
 * @author Charles Song
 * @date 2020-6-10
 */
public class _491_FindSubsequences {
    public static void main (String[] args) {
        int[] nums = {3,6,7,7};
        Sol2_FindSubsequences sol = new Sol2_FindSubsequences();
        sol.findSubsequences(nums);
    }
}
class Sol2_FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> lists = new LinkedList<>();
        for (int i = 0; i < nums.length; i ++) {
            if (lists.size() == 0) {
                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                lists.add(list);
            } else {
                List<List<Integer>> temp = new ArrayList<>();
                for (List<Integer> list : lists) {
                    if (list.get(list.size() - 1) <= nums[i]) {
                        if (list.get(list.size() - 1) != nums[i]) {
                            List<Integer> l = new ArrayList<>(list);
                            temp.add(l);
                        }
                        list.add(nums[i]);
                    }
                }
                List<Integer> self = new ArrayList<>();
                self.add(nums[i]);
                temp.add(self);
                lists.addAll(temp);
            }
        }
        Iterator<List<Integer>> iter = lists.iterator();
        for (;iter.hasNext();) {
            List<Integer> list = iter.next();
            if (list.size() == 1) {
                iter.remove();
            }
        }
        return lists;
    }

    public static List<Integer> clone (List<Integer> l) {
        List<Integer> list = new ArrayList<>();
        for (int var : l) {
            list.add(new Integer(var));
        }

        return list;
    }

}

/**
 * 有问题
 */
class Sol1_FindSubsequences {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        List<List<Integer>> list = backtrace(nums, 0, nums.length - 1);
        Iterator<List<Integer>> iter = list.iterator();
        for (;iter.hasNext();) {
            List<Integer> l = iter.next();
            if (l.size() > 1) {
                result.add(l);
            }
        }
        return result;
    }

    public static List<List<Integer>> backtrace (int[] nums, int start, int end) {
        List<Integer> list = new LinkedList<>();
        int num = nums[start];
        list.add(num);
        if (start == end) {
            List<List<Integer>> result = new LinkedList<>();
            result.add(list);
            return result;
        }
        List<List<Integer>> back = backtrace(nums, start + 1, end);
        List<List<Integer>> backt = new LinkedList<>();
        boolean needAddNum = true;
        for (List<Integer> l : back) {
            int first = l.get(0);
            if (first >= num) {
                List<Integer> lt = new LinkedList<>();
                for (int var : l) {
                    lt.add(var);
                }
                backt.add(lt);
                l.add(0, num);
                if (first == num) {
                    needAddNum = false;
                }
            }
        }
        if (needAddNum) {
            back.add(list);
        }
        back.addAll(backt);
        return back;
    }
}
