package cn.neyzoter.leetcode.algo.array;

import java.util.*;

/**
 * 49. 字母异位词分组
 */
public class GroupAnagrams {
    public static void main (String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = {};
        Solution1_GroupAnagrams solution1_groupAnagrams = new Solution1_GroupAnagrams();
        System.out.println(solution1_groupAnagrams.groupAnagrams(strs2));
    }
}

class Solution1_GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map= new HashMap<>();
        List<List<String>> list = new ArrayList<>();

        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String key = String.valueOf(arr);
            if (!map.containsKey(key)) {
                List<String> l = new LinkedList<>();
                l.add(str);
                map.put(key, l);
            } else {
                map.get(key).add(str);
            }
        }
        Iterator<Map.Entry<String, List<String>>> iter = map.entrySet().iterator();
        for (;iter.hasNext();) {
            list.add(iter.next().getValue());
        }

        return list;
    }
}