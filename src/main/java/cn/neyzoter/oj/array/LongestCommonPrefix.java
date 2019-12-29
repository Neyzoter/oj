package cn.neyzoter.oj.array;

/**
 * 14.最长公共前缀
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[][] strss = {{"flower","flow","flight"},{"dog","racecar","car"}};
        Solution1_LongestCommonPrefix solution1_longestCommonPrefix = new Solution1_LongestCommonPrefix();
        for (String[] strs : strss) {
            System.out.println("strs = " + strs + "\n\tprefix = " + solution1_longestCommonPrefix.longestCommonPrefix(strs));
        }
    }
}

/**
 * 暴力搜索
 */
class Solution1_LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        int str_num = strs.length;
        String prefix = "";
        if (str_num == 0) {
            return prefix;
        }
        int str_min_len = strs[0].length();
        for (String str : strs) {
            if (str.length() < str_min_len) {
                str_min_len = str.length();
            }
        }
        for (int i = 0 ; i < str_min_len ; i ++) {
            char ch = strs[0].charAt(i);
            for (String str : strs) {
                if (str.charAt(i) != ch) {
                    return prefix;
                }
            }
            prefix += ch;
        }
        return prefix;
    }
}
