package cn.neyzoter.exam.littleredbook;

import java.util.*;

/**
 * @author neyzoter
 */
public class Intv2 {
    public static void main(String[] args) {

    }
    public static void taskSeq(HashMap<String, Set<String>> map) {
        Set<Map.Entry<String, Set<String>>> set = map.entrySet();
        HashMap<String, Set<String>> maptemp = new HashMap<>(map);
        for (Map.Entry<String, Set<String>> e : set) {
            Set<String> s = e.getValue();
            for (String t : s) {
                if (!map.containsKey(t)) {
                    maptemp.put(t, new HashSet<>());
                }
            }
        }
        set = maptemp.entrySet();
        for (;maptemp.size() > 0;) {
            List<String> removeKey = new ArrayList<>();
            for (Map.Entry<String, Set<String>> e : set) {
                Set<String> dep = e.getValue();
                if (dep.size() == 0) {
                    maptemp.remove(e.getKey());
                    removeKey.add(e.getKey());
                    System.out.print(e.getKey());
                }
            }
            for (String rk : removeKey) {
                Set<Map.Entry<String, Set<String>>> newSet = map.entrySet();
                for (Map.Entry<String, Set<String>> n : newSet) {
                    Set<String> newDep = n.getValue();
                    newDep.remove(rk);
                }
            }
        }
    }
}