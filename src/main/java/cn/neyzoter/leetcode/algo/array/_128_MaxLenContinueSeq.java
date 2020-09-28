package cn.neyzoter.leetcode.algo.array;

import java.util.*;
public class _128_MaxLenContinueSeq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int[] nums = new int[line.length];
        for (int i = 0 ; i < nums.length; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        Sol_128_MaxLenContinueSeq sol = new Sol_128_MaxLenContinueSeq();
        System.out.println(sol.longestConsecutive(nums));
    }
}
class Sol_128_MaxLenContinueSeq {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        HashMap<Integer, Boolean> hm = new HashMap<>();
        for (int n : nums) {
            hm.put(n, false);
        }
        Set<Map.Entry<Integer, Boolean>> set = hm.entrySet();
        int res = 0;
        for (Map.Entry<Integer, Boolean> entry : set) {
            Integer key = entry.getKey();
            Boolean val = entry.getValue();
            if (val) {
                continue;
            } else {
                hm.put(key, true);
                // 向左侧扩散
                Integer keyTemp = key - 1;
                int resTemp = 1;
                while (hm.containsKey(keyTemp)) {
                    resTemp++;
                    hm.put(keyTemp, true);
                    keyTemp--;
                }
                // 向右侧扩散
                keyTemp = key + 1;
                while (hm.containsKey(keyTemp)) {
                    resTemp++;
                    hm.put(keyTemp, true);
                    keyTemp++;
                }
                res = Math.max(resTemp, res);
            }
        }
        return res;
    }
}