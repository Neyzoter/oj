package cn.neyzoter.sword;

import java.util.HashSet;

/**
 * 面试题49. 丑数 NthUglyNumber
 * @author Charles Song
 * @date 2020-4-5
 */
public class NthUglyNumber {
    public static void main (String[] args) {
        int n = 1690;
//        Solution1_NthUglyNumber solution1_nthUglyNumber = new Solution1_NthUglyNumber();
        Solution2_NthUglyNumber solution2_nthUglyNumber = new Solution2_NthUglyNumber();
        System.out.println(solution2_nthUglyNumber.nthUglyNumber(n));
    }
}

/**
 * 动态规划1
 * n较大时，会超时
 */
class Solution1_NthUglyNumber {
    public int nthUglyNumber(int n) {
        if (n == 1) {
            return 1;
        }
        HashSet<Integer> uglyNum = new HashSet<>();
        uglyNum.add(1);
        for (int idx = 2 , uglyNN = 1;  ; idx ++) {
            if (divBy(idx, 2, uglyNum) || divBy(idx, 3, uglyNum) || divBy(idx, 5, uglyNum)) {
                uglyNum.add(idx);
                uglyNN ++;
                if (uglyNN == n) {
                    return idx;
                }
            }
        }
    }

    /**
     *
     * @param num 被除数
     * @param div 除数
     * @param dp 是否是丑数的结果
     * @return 是否满足被2整除，且整除结果为丑数
     */
    public boolean divBy (int num , int div, HashSet dp) {
        if (num % div == 0) {
            if (dp.contains(num / div)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}

/**
 * 动态规划2
 */
class Solution2_NthUglyNumber {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int idx2 = 0 , idx3 = 0, idx5 = 0;
        for (int i = 1 ; i < n ; i ++) {
            int ugly2 = dp[idx2] * 2;
            int ugly3 = dp[idx3] * 3;
            int ugly5 = dp[idx5] * 5;
            int uglyNum = Math.min(Math.min(ugly2,ugly3), ugly5);
            dp[i] = uglyNum;
            // 此处不使用if else，因为有可能ugly数字相同
            if (uglyNum == ugly2) {
                idx2 ++;
            }
            if (uglyNum == ugly3) {
                idx3 ++;
            }
            if (uglyNum == ugly5) {
                idx5 ++;
            }
        }
        return dp[n - 1];
    }
}
