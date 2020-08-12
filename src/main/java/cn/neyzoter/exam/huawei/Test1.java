package cn.neyzoter.exam.huawei;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Test1
 * 100% AC
 * @author neyzoter
 */
public class Test1 {
    public static final int COFFEE_PRICE = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> moneyType = new HashSet<>();
        int seq = 0;
        moneyType.add(5);moneyType.add(10);moneyType.add(20);
        HashMap<Integer, Integer> moneyKeeped = new HashMap<>();
        String str = sc.nextLine();
        if (str.length() == 0) {
            print(true, seq);
            return;
        }
        String[] strs = str.split(",");
        for (String moneyStr : strs) {
            int money = Integer.parseInt(moneyStr);
            seq++;
            if (!moneyType.contains(money)) {
                print(false, seq);
                return;
            }
            int num = moneyKeeped.getOrDefault(money, 0);
            moneyKeeped.put(money, num + 1);
            int res = money - COFFEE_PRICE;
            if (res == 5) {
                num = moneyKeeped.getOrDefault(5, 0);
                if (num != 0) {
                    moneyKeeped.put(5, num - 1);
                } else {
                    print(false, seq);
                    return;
                }
            } else if (res == 15) {
                int num5 = moneyKeeped.getOrDefault(5, 0);
                int num10 = moneyKeeped.getOrDefault(10, 0);
                if (num5 != 0 && num10 != 0) {
                    moneyKeeped.put(5, num5 - 1);
                    moneyKeeped.put(10, num10 - 1);
                } else if (num5 >= 3) {
                    moneyKeeped.put(5, num5 - 3);
                } else {
                    print(false, seq);
                    return;
                }
            }
        }
        print(true, seq);
    }

    public static void print(boolean res, int seq) {
        String result = res ? "true" : "false";
        System.out.println(String.format("%s,%d", result, seq));
    }
}
