package cn.neyzoter.leetcode.algo.array;

import java.util.HashMap;

/**
 * 10. 正则表达式匹配
 * @author Charles Song
 * @date 2020-6-1
 */
public class RegexIsMatch {
    public static void main (String[] args) {
        Sol2_RegexIsMatch regexIsMatch = new Sol2_RegexIsMatch();
        System.out.println(regexIsMatch.isMatch("mississippi","mis*is*p*."));
        Sol1_RegexIsMatch sol = new Sol1_RegexIsMatch();
        System.out.println(sol.isMatch("aa","a*"));
    }
}


/**
 * 存在重复子问题，可以通过动态规划来实现剪枝
 */
class Sol2_RegexIsMatch {
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) {
            return s.isEmpty();
        }
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }
    }
}

/**
 * 剪枝
 */
class Sol1_RegexIsMatch {
    public static HashMap<String, Boolean> map = new HashMap<>();
    public boolean isMatch(String s, String p) {
        // 重要
        map.clear();
        return dp(0, 0, s, p);
    }

    public static boolean dp (int i, int j, String string, String pattern) {
        String idxStr = getIdxStr(i, j);
        if (map.containsKey(idxStr)) {
            return map.get(idxStr);
        }
        String s = string.substring(i);
        String p = pattern.substring(j);
        if (p.isEmpty()) {
            boolean sEmp = s.isEmpty();
            map.put(idxStr, sEmp);
            return sEmp;
        }
        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            // 匹配0个和匹配1个
            boolean match = dp(i, j + 2, string, pattern) || (firstMatch && dp(i + 1,j, string, pattern));
            map.put(idxStr, match);
            return match;
        } else {
            boolean match = firstMatch && dp(i + 1, j + 1, string, pattern);
            map.put(idxStr, match);
            return match;
        }
    }

    public static String getIdxStr (int i, int j) {
        return String.format("%d_%d" ,i , j);
    }
}
