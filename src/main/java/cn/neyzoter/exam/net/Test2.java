package cn.neyzoter.exam.net;

import com.google.gson.internal.$Gson$Preconditions;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 测试2
 * 网易
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int delta = n - m;
        ArrayList<Integer> list = new ArrayList<>(m);
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int num = scanner.nextInt();
            list.add(num);
            set.add(num);
        }
        int idx = 0;
        int numSum = 0;
        int val = 1;
        for (val = 1; val <= n && delta > 0; val ++) {
            if (!set.contains(val)) {
                for (; idx <= list.size(); ) {
                    if (idx == list.size() || list.get(idx) > val) {
                        System.out.print(val);
                        delta--;
                        numSum++;
                        if (numSum != n) {
                            System.out.print(" ");
                        }
                        break;
                    } else {
                        System.out.print(list.get(idx));
                        idx++;
                        numSum++;
                        if (numSum != n) {
                            System.out.print(" ");
                        }
                    }
                }
            }
        }
        for (;idx < list.size();idx++) {
            System.out.print(list.get(idx));
            numSum++;
            if (numSum != n) {
                System.out.print(" ");
            }
        }
    }
}
