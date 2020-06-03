package cn.neyzoter.leetcode.algo.array;

/**
 * 29. 两数相除 Divide
 * @author Charles Song
 * @date 2020-4-12
 */
public class Divide {
    public static void main (String[] args) {
        int dividend = Integer.MIN_VALUE; int divisor = -3;
//        Solution2_Divide solution2_divide = new Solution2_Divide();
        Solution1_Divide solution1_divide = new Solution1_Divide();
        System.out.println(String.format("dividend = %d , divisor = %d , result = %d", dividend, divisor, solution1_divide.divide(dividend, divisor)));
    }
}

class Solution1_Divide {
    public int divide(int dividend, int divisor) {
        int result = divideVabs(dividend, divisor);
        boolean resultIsPos = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0);
        if (resultIsPos) {
            if (result == Integer.MIN_VALUE) {
                result = Integer.MAX_VALUE;
            } else {
                result = -result;
            }
        }
        return result;
    }
    public int divideVabs (int dividend, int divisor) {
        // 转化为负数
        int vabsDividend = dividend < 0 ? dividend : -dividend;
        int vabsDivisor = divisor < 0 ? divisor : -divisor;
        if (vabsDividend > vabsDivisor) {
            return 0;
        }
        int sum = vabsDivisor;
        int result = -1;
        for (;vabsDividend - sum <= sum;) {
            sum += sum;
            result += result;
        }
        int res = vabsDividend - sum;
        result = divideVabs(res, divisor) + result;
        return result;
    }
}

/**
 * 超时
 */
class Solution2_Divide {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        int sum = 0;
        // 转化为负数
        int vabsDividend = dividend < 0 ? dividend : -dividend;
        int vabsDivisor = divisor < 0 ? divisor : -divisor;
        int result = 0;
        for (result = 0; vabsDividend - sum <= vabsDivisor; result --) {
            sum += vabsDivisor;
        }
        int sign;
        if (dividend > 0 && divisor >0) {
            sign = 1;
        } else if (dividend < 0 && divisor < 0){
            sign = 1;
        } else {
            sign = -1;
        }
        if (sign == -1) {
            return result;
        } else {
            if (result != Integer.MIN_VALUE) {
                return -result;
            } else {
                return Integer.MAX_VALUE;
            }
        }
    }
}