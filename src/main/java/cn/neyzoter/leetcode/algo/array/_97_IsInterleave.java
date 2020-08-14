package cn.neyzoter.leetcode.algo.array;

import java.util.HashMap;

/**
 * 97. 交错字符串
 */
public class _97_IsInterleave {
    public static void main(String[] args) {
        String s = "121";
    }
}

/**
 * 递归法
 * 超时
 */
class Sol1_97_IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1, 0, s2, 0, s3, 0);
    }
    public boolean isInterleave(String s1, int ptr1, String s2, int ptr2, String s3, int ptr3) {
        if (s1.length() == ptr1 && s2.length() == ptr2 && s3.length() == ptr3) {
            return true;
        }
        boolean interleave = false;
        if (s3.length() > ptr3) {
            char ch3 = s3.charAt(ptr3);
            if (s1.length() > ptr1) {
                char ch1 = s1.charAt(ptr1);
                if (ch1 == ch3) {
                    interleave |= isInterleave(s1, ptr1 + 1, s2, ptr2, s3, ptr3 + 1);
                }
            }
            if (s2.length() > ptr2) {
                char ch2 = s2.charAt(ptr2);
                if (ch2 == ch3) {
                    interleave |= isInterleave(s1, ptr1, s2, ptr2 + 1, s3, ptr3 + 1);
                }
            }
        }
        return interleave;
    }
}

/**
 * 剪枝+递归
 * 用时超过9.34%
 * 内存超过5.49%
 */
class Sol2_97_IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>();
        return isInterleave(s1, 0, s2, 0, s3, 0, map);
    }
    public boolean isInterleave(String s1, int ptr1, String s2, int ptr2, String s3, int ptr3, HashMap<String, Boolean> map) {
        if (s1.length() == ptr1 && s2.length() == ptr2 && s3.length() == ptr3) {
            map.put(String.format("%d_%d_%d", ptr1, ptr2, ptr3), true);
            return true;
        }
        String key = String.format("%d_%d_%d", ptr1, ptr2, ptr3);
        if (map.containsKey(key)) {
            return (boolean) map.get(key);
        }
        boolean interleave = false;
        if (s3.length() > ptr3) {
            char ch3 = s3.charAt(ptr3);
            if (s1.length() > ptr1) {
                char ch1 = s1.charAt(ptr1);
                if (ch1 == ch3) {
                    interleave |= isInterleave(s1, ptr1 + 1, s2, ptr2, s3, ptr3 + 1, map);
                }
            }
            if (s2.length() > ptr2) {
                char ch2 = s2.charAt(ptr2);
                if (ch2 == ch3) {
                    interleave |= isInterleave(s1, ptr1, s2, ptr2 + 1, s3, ptr3 + 1, map);
                }
            }
        }
        map.put(key, interleave);
        return interleave;
    }
}


/**
 * 动态规划
 * f(i, j) = (f(i - 1, j) and s1[i] == s3[i + j]) || (f(i, j - 1) and s2[j - 1] == s3[i + j])
 * 边界条件f(0, 0) = true
 *
 * 运行时间：34.02%
 * 内存：84.68%
 */
class Sol3_97_IsInterleave {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        boolean temp = true;
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch3 = s3.charAt(i);
            temp = temp && (ch1 == ch3);
            dp[i + 1][0] = temp;
        }
        temp = true;
        for (int i = 0; i < s2.length(); i++) {
            char ch2 = s2.charAt(i);
            char ch3 = s3.charAt(i);
            temp = temp && (ch2 == ch3);
            dp[0][i + 1] = temp;
        }
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            for (int j = 0; j < s2.length(); j++) {
                char ch2 = s2.charAt(j);
                char ch3 = s3.charAt(i + j + 1);
                dp[i + 1][j + 1] = (dp[i][j + 1] && ch1 == ch3) || (dp[i + 1][j] && ch2 == ch3);
            }
        }
        return dp[s1.length()][s2.length()];
    }
}