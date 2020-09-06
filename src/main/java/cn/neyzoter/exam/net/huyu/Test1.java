package cn.neyzoter.exam.net.huyu;

import java.util.*;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[][] record = new String[n][2];
        HashMap<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] r = sc.nextLine().split(" ");
            Set<String> set = map.getOrDefault(r[1], new HashSet<>());
            set.add(r[0]);
            map.put(r[1], set);
//            record[i][0] = r[0];
//            record[i][1] = r[1];
        }
        Set<Map.Entry<String, Set<String>>> res = map.entrySet();
        int sum = 0;
        for (Map.Entry<String, Set<String>> entry : res) {
            sum += entry.getValue().size() >= 2 ? 1 : 0;
        }
        System.out.println(sum);
    }
}
