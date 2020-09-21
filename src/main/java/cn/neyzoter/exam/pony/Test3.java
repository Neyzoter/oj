package cn.neyzoter.exam.pony;

import java.util.*;

/**
 * @author neyzoter
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<Integer> list = new ArrayList<>(n);
        for (int i = 0; i < n; i ++) {
            list.add(sc.nextInt());
        }
        boolean desc = false;
        int sum = 0;
        Integer valley = null;
        Integer valleyIdx = null;
        Integer last = null;
        while (!desc) {
            desc = true;
            valley = null;
            valleyIdx = null;
            last = null;
            for (int i = 0;i < list.size(); i++) {
                int val = list.get(i);
                if (valley == null) {
                    valley = val;
                    valleyIdx = i;
                } else {
                    if (last > val) {
                        sum += last - valley;
                        list.remove(valleyIdx);list.remove(i - 1);
                        desc = false;
                        break;
                    }
                }
                last = val;
            }
        }
        if (last != null && last > valley) {
            sum += last - valley;
            list.remove(valleyIdx);list.remove(list.size() - 1);
        }
        System.out.println(sum);
    }
}
