package cn.neyzoter.sword;

import java.util.Arrays;

public class _45_MinNum {
    public static void main(String[] args) {

    }
}

class Solution {
    public String minNumber(int[] nums) {
        String[] str = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            str[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(str, (s1, s2) -> {
            int len1 = s1.length(), len2 = s2.length();
            int lenMax = Math.max(len1, len2);
            for (int i = 0, j = 0; i < lenMax && j < lenMax; ) {
                if (s1.charAt(i) > s2.charAt(j)) {
                    return 1;
                } else if (s1.charAt(i) < s2.charAt(j)) {
                    return -1;
                }
                i = i + 1;
                j = j + 1;
                if (i == lenMax || j == lenMax) {
                    break;
                } else {
                    i %= len1;
                    j %= len2;
                }
            }
            return s1.charAt(s1.length() - 1) - s2.charAt(s2.length() - 1);
        });
        // System.out.print(Arrays.toString(str));
        StringBuilder sb = new StringBuilder();
        for (String s : str) {
            sb.append(s);
        }
        return sb.toString();
    }
}