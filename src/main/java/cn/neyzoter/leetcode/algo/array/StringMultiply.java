package cn.neyzoter.leetcode.algo.array;

/**
 * 43. 字符串相乘 String Multiply
 * @author Charles Song
 * @date 2020-4-11
 */
public class StringMultiply {
    public static void main (String[] args) {
        String num1 = "123"; String num2 = "0";
        Solution1_StringMultiply solution1_stringMultiply = new Solution1_StringMultiply();
        System.out.println(String.format("num1 = %s , num2 = %s, result = %s", num1, num2, solution1_stringMultiply.multiply(num1,num2)));
    }
}

class Solution1_StringMultiply {
    public String multiply(String num1, String num2) {
        int num1Len = num1.length();
        int num2Len = num2.length();
        char[] result = new char[num1Len + num2Len];
        for (int i = num1Len - 1 ; i >= 0 ; i --) {
            for (int j = num2Len - 1 ; j >= 0 ; j --) {
                int val1 = num1.charAt(i) - '0'; int val2 = num2.charAt(j) - '0';
                int multi = val1 * val2;
                int bit1 = multi % 10; int bit2 = multi / 10;
                result[i + j + 1] += bit1;
                int c = result[i + j + 1] / 10;
                result[i + j + 1] %= 10;
                result[i + j] += bit2 + c;
                c = result[i + j] / 10;
                result[i + j] %= 10;
                if (c > 0) {
                    result[i + j - 1] += c;
                }
            }
        }
        int start = 0;boolean findNotZero = false;
        for (int i = 0; i < num1Len + num2Len; i ++) {
            if (result[i] != 0 && findNotZero == false) {
                findNotZero = true;
                start = i;
            }
            result[i] += '0';
        }
        if (findNotZero == true) {
            return String.copyValueOf(result,start,result.length - start);
        } else {
            return "0";
        }
    }
}
