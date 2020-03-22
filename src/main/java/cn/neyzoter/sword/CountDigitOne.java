package cn.neyzoter.sword;

/**
 * 面试题43. 1-n整数中1出现的次数
 * @author Neyzoter Song
 * @date 2020-3-22
 */
public class CountDigitOne {
    public static void main (String[] args) {
        int n = 20;
        Solution1_CountDigitOne solution1_countDigitOne = new Solution1_CountDigitOne();
        System.out.println(String.format("n = %d, one num = %d",n, solution1_countDigitOne.countDigitOne(n)));
    }
}

class Solution1_CountDigitOne {
    public int countDigitOne(int n) {
        String digital = String.valueOf(n);
        int len = digital.length();
        int oneNum = 0;
        for (int i = 0; i < len ; i ++) {
            int pow = (int) Math.pow(10, len -1 - i);
            int left = (i == 0)?0:Integer.parseInt(digital.substring(0, i));
            int mid = digital.charAt(i) - '0';
            int right = (i == len - 1)?0:Integer.parseInt(digital.substring(i + 1, len));
            if (mid > 1) {
                oneNum += (left + 1) * pow;
            } else if (mid == 1) {
                oneNum += left * pow + (right + 1);
            } else {
                oneNum += left * pow;
            }
        }
        return oneNum;
    }
}
