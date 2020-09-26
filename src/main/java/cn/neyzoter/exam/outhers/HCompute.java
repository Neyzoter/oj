package cn.neyzoter.exam.outhers;

import java.util.*;

/**
 * 计算信息熵
 * @author neyzoter
 */
public class HCompute {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int sum = str.length();
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        Set<Map.Entry<Character, Integer>> set = hm.entrySet();
        double infoH = 0;
        for (Map.Entry<Character, Integer> entry : set) {
//            char key = entry.getKey();
            int val = entry.getValue();
            double p = (double) val / (double) sum;
            infoH += p * Math.log(p) / Math.log(2);
        }
        System.out.println(String.format("%.2f", -infoH));
    }
}
