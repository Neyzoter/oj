package cn.neyzoter.leetcode.algo.array;


import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 * @author Charles Song
 * @date 2020-7-3
 */
public class _438_FindAnagrams {
    public static void main (String[] args) {
        String s = "cbaebabacd";
        String p = "abc";
        Sol1_438_FindAnagrams sol = new Sol1_438_FindAnagrams();
        System.out.println(sol.findAnagrams(s, p));
    }
}
class Sol1_438_FindAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        if (s.length() < p.length()) {
            return new ArrayList<>();
        }
        Map<Character, Integer> itemMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        char[] pSplit = p.toCharArray();
        for (char c : pSplit) {
            if (itemMap.containsKey(c)) {
                itemMap.put(c, itemMap.get(c) + 1);
            } else {
                itemMap.put(c, 1);
            }
        }
        int valid = itemMap.size();
        for (int i = 0; i < p.length();i ++) {
            valid = put(itemMap, s.charAt(i), valid);
        }
        if (valid == 0) {
            list.add(0);
        }
        for (int i = p.length(), j = 0; i < s.length();i ++, j++) {
            valid = put(itemMap, s.charAt(i), valid);
            valid = rm(itemMap, s.charAt(j), valid);
            if (valid == 0) {
                list.add(j + 1);
            }
        }
        return list;
    }

    public static int put (Map<Character, Integer> map, char ch, int valid) {
        if (map.containsKey(ch)) {
            int v = map.get(ch) - 1;
            map.put(ch, v);
            if (v == 0) {
                valid --;
            } else if (v == -1){
                valid ++;
            }
        }
        return valid;
    }
    public static int rm (Map<Character, Integer> map, char ch, int valid) {
        if (map.containsKey(ch)) {
            int v = map.get(ch) + 1;
            map.put(ch, v);
            if (v == 0) {
                valid --;
            } else if (v == 1){
                valid ++;
            }
        }
        return valid;
    }
}