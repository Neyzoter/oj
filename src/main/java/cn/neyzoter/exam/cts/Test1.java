package cn.neyzoter.exam.cts;

import java.util.Scanner;

/**
 * Test1
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt();
        Test1 main = new Test1();
//        System.out.print(main.CalulateMethodCount(money));
        System.out.println(main.CalulateMethodCountByStr(money));

        System.out.println(main.multiply("123231321313213", "2132321321321321312321"));
    }
    /**
     *
     * @param num_money int整型 奖金的总数,单位为元
     * @return int整型
     */
    public long CalulateMethodCount (int num_money) {
        // write code here
        long[] dp = new long[num_money + 1];
        dp[0] = 1;
        for (int money = 1; money <= num_money; money++) {
            long num = 0;
            for (int m = 1; m <= money; m++) {
                int res = money - m;
                num += dp[res];
            }
            dp[money] = num;
        }
        return dp[num_money];
    }
    public String CalulateMethodCountByStr (int num_money) {
        //int sum
        String sum = "1";
        String mul = "2";
        for (int i = 1; i < num_money; i++) {
            sum = multiply(sum, mul);
        }
        return sum;
    }
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

