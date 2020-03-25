package cn.neyzoter.sword;


/**
 * 面试题44. 数字序列中某一位的数字 findNthDigit
 * @author Charles Song
 * @date 2020-3-25
 */
public class FindNthDigit {
    public static void main (String[] args) {
        int n = 0;
        Solution1_FindNthDigit solution1_findNthDigit = new Solution1_FindNthDigit();
        System.out.println(String.format("n = %d, char = %d", n , solution1_findNthDigit.findNthDigit(n)));
    }
}

class Solution1_FindNthDigit {
    public static final int ONE_DIGIT = 10;
    public int findNthDigit(int n) {
        if (n < ONE_DIGIT) {
            return n;
        }
        long num = 1;
        int nAt = 1;
        for (int i = 1;  ; i ++) {
            long nextNum = num + 9 * (long) Math.pow(10, i - 1) * i;
            if (nextNum > n) {
                nAt = i;
                break;
            } else {
                num = nextNum;
            }
        }
        int left = n - (int) num;
        // 商数
        int quotient = left / nAt;
        // 余数
        int remainder = left % nAt;
        // 找到nAt位的数字的最小值
        int base = (int) Math.pow(10, nAt - 1);
        // 找到字符所在数字
        int basePlus = base + quotient;
        // 找到字符，并转化为数字
        int ch = String.valueOf(basePlus).charAt(remainder) - '0';
        return ch;
    }
}
