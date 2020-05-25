package cn.neyzoter.sword;

import java.util.Arrays;

/**
 * 面试题17. 打印从1到最大的n位数
 */
public class Print1ToNLenNum {
    public static void main (String[] args) {
//        StringBuilder sb = new StringBuilder(5);
//        sb.append("00009");
//        System.out.println(Solution1_Print1ToNLenNum.inc(sb).toString());
        String result = Arrays.toString(Solution1_Print1ToNLenNum.printNumbers(0));
        System.out.println(result);
    }
}

class Solution1_Print1ToNLenNum {
    public static int[] printNumbers(int n) {
        StringBuilder strb = new StringBuilder(n);
        for (int i = 0; i < n ;i ++) {
            strb.append("0");
        }
        StringBuilder max = new StringBuilder(n);
        for (int i = 0; i < n; i ++) {
            max.append("9");
        }
        String maxStr = max.toString();
        String str = "";
        int[] result = new int[(int)Math.pow(10, n) - 1];
        for (int i = 0;i < Math.pow(10,n) - 1;i++) { // !maxStr.equals(str)
            inc(strb);
            str = strb.toString();
            result[i] = getNum(str);
        }
        return result;
    }

    public static StringBuilder inc (StringBuilder base) {
        base.setCharAt(base.length() - 1, (char)(base.charAt(base.length() - 1) + 1));
        for (int idx = base.length() - 1; idx >= 0; idx --) {
            char ch = base.charAt(idx);
            if (ch > '9') {
                base.setCharAt(idx, (char)(ch - 10));
                base.setCharAt(idx - 1, (char)(base.charAt(idx - 1) + 1));
            } else {
                break;
            }
        }
        return base;
    }

    public static void printNum (String str) {
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) != '0') {
                System.out.println(str.substring(i));
                break;
            }
        }
    }

    public static int getNum (String str) {
        for (int i = 0; i < str.length(); i ++) {
            if (str.charAt(i) != '0') {
                return Integer.parseInt(str.substring(i));
            }
        }
        return 0;
    }
}
