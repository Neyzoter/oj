package cn.neyzoter.sword;

/**
 * 面试题16. 数值的整数次方 MyPow
 * @author Charles Song
 * @date 2020-4-6
 */
public class MyPow {
    public static void main (String[] args) {
        double x1 = 2.0; int n1 = 10;
        double x2 = 2.1; int n2 = 3;
        double x3 = 2.0; int n3 = -2;
        Solution1_MyPow solution1_myPow = new Solution1_MyPow();
//        Solution2_MyPow solution2_myPow = new Solution2_MyPow();
        System.out.println(String.format("x = %f, n = %d, pow = %f", x1, n1, solution1_myPow.myPow(x1, n1) ));
        System.out.println(String.format("x = %f, n = %d, pow = %f", x2, n2, solution1_myPow.myPow(x2, n2) ));
        System.out.println(String.format("x = %f, n = %d, pow = %f", x3, n3, solution1_myPow.myPow(x3, n3) ));
    }
}

/**
 * 该方法超时
 */
class Solution1_MyPow {
    public double myPow(double x, int n) {
        double val = 1;
        // 注意int取正可能超过int的最大值
        long absN = (long) n;
        absN = absN < 0 ? -absN : absN;

        if (x == 1) {
            return 1;
        } else if (x == -1 ) {
            return absN % 2 == 0 ? 1 : -1;
        }
        x = n < 0 ? 1 / x : x;
        for (int i = 0 ; i < absN ; i ++) {
            val *= x;
        }
        return val;
    }
}

/**
 * 二进制幂
 */
class Solution2_MyPow {
    public double myPow(double x, int n) {
        double val = 1;
        x = n < 0 ? 1 / x : x;
        // 注意int取正可能超过int的最大值
        long absN = (long) n;
        absN = absN < 0 ? -absN : absN;
        while (absN > 0) {
            if ((absN & 1) == 1) {
                val *= x;
            }
            x *= x;
            absN >>= 1;
        }
        return val;
    }
}
