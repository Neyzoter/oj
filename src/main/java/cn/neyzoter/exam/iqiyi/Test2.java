package cn.neyzoter.exam.iqiyi;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> hm = new HashMap<>();
        Integer v = null;
        Integer n = null;
        String[] vals = sc.nextLine().split(" ");
        for (int i = 0; i < vals.length; i++) {
            int val = Integer.parseInt(vals[i]);
            int num = hm.getOrDefault(val, 0) + 1;
            hm.put(val, num);
            if (v == null) {
                v = val;
                n = num;
            } else if (n < num){
                v = val;
                n = num;
            }
        }
        System.out.print(v);
    }
}
