package cn.neyzoter.exam.tencent;

import java.util.*;

/**
 * @author neyzoter
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        HashMap<String, Integer> hm = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            if (str.length() == 0) {
                i--;
                continue;
            }
            hm.put(str, hm.getOrDefault(str, 0) + 1);
        }
        TreeMap<Integer, TreeSet<String>> tm = new TreeMap<>();
        Set<Map.Entry<String, Integer>> set = hm.entrySet();
        for (Map.Entry<String, Integer> e : set) {
            int num = e.getValue();
            String str = e.getKey();
            TreeSet<String> ts = tm.getOrDefault(num, new TreeSet<>());
            ts.add(str);
            tm.put(num, ts);
        }
        Iterator<Integer> iter = tm.navigableKeySet().descendingIterator();
        int ktemp = K;
        for (;iter.hasNext() && ktemp > 0;) {
            int num = iter.next();
            TreeSet<String> treeSet = tm.get(num);
            Iterator<String> tsIter = treeSet.iterator();
            for (;tsIter.hasNext() && ktemp > 0;) {
                ktemp--;
                System.out.println(tsIter.next() + " " + num);
            }
        }
        iter = tm.navigableKeySet().iterator();
        ktemp = K;
        for (;iter.hasNext() && ktemp > 0;) {
            int num = iter.next();
            TreeSet<String> treeSet = tm.get(num);
            Iterator<String> tsIter = treeSet.iterator();
            for (;tsIter.hasNext() && ktemp > 0;) {
                ktemp--;
                System.out.println(tsIter.next() + " " + num);
            }
        }

    }
}
