package cn.neyzoter.exam.sensetime;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * 测试1
 * @author neyzoter
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('G', 0);map.put('o', 0);map.put('d', 0);
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == 'G') {
                map.put(ch, map.get(ch) + 1);
            } else if (ch == 'o' && map.get('G') > 0) {
                map.put(ch, map.get(ch) + 1);
            } else if (ch == 'd' && map.get('G') > 0 && map.get('o') > 1) {
                map.put(ch, map.get(ch) + 1);
            }
            int gnum = map.get('G');
            int onum = map.get('o');
            int dnum = map.get('d');
            int newNum = Math.min(onum / 2, Math.min(gnum, dnum));
            num += newNum;
            if (newNum != 0) {
                map.put('G', map.get('G') - newNum);
                map.put('o', map.get('o') - 2 * newNum);
                map.put('d', map.get('d') - newNum);
            }
        }
        System.out.println(num);
    }
}
