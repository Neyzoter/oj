package cn.neyzoter.exam.duxiaoman;

import java.util.HashMap;
import java.util.Scanner;

/**
 * AC 100%
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cont = sc.nextLine();
        String need = sc.nextLine();
        int sum = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < cont.length(); i++) {
            char ch = cont.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < need.length(); i++) {
            char ch = need.charAt(i);
            if (hm.getOrDefault(ch, 0) > 0) {
                hm.put(ch, hm.get(ch) - 1);
                sum++;
            }
        }
        System.out.println(sum);
    }
}
