package cn.neyzoter.exam.net.huyu;

import java.util.*;

/**
 * AC 90%
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Set<Pair<Integer, Integer>> canArrive = new HashSet<>();
            int x = 0, y = 0;
            canArrive.add(new Pair<>(x, y));
            int endX = 0, endY = 0;
            for (int i = 0; i < n; i++) {
                int dir = sc.nextInt();
                int suc = sc.nextInt();
                if (suc == 1) {
                    switch (dir) {
                        case 0 : y += 1;break; // 上
                        case 1 : y -= 1;break; // 下
                        case 2 : x -= 1;break; // 左
                        case 3 : x += 1;break; // 右
                    }
                    canArrive.add(new Pair<>(x, y));
                }
                if (i == n - 1) {
                    endX = x;
                    endY = y;
                }
            }
            System.out.println(bfs(canArrive, endX, endY));
        }
    }
    public static int bfs(Set<Pair<Integer, Integer>> can, int ex, int ey) {
        if (ex == 0 && ey == 0) {
            return 0;
        }
        Set<Pair<Integer, Integer>> arrived = new HashSet<>();
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(0, 0));
        arrived.add(new Pair<>(0, 0));
        int step = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair<Integer, Integer> pair = q.poll();
                int x = pair.getKey();
                int y = pair.getValue();
                if (ex == x && ey == y) {
                    return step;
                }
                Pair<Integer, Integer> newPos = new Pair<>(x - 1, y);
                if (can.contains(newPos) && !arrived.contains(newPos)) {
                    q.add(newPos);
                    arrived.add(newPos);
                }
                newPos = new Pair<>(x + 1, y);
                if (can.contains(newPos) && !arrived.contains(newPos)) {
                    q.add(newPos);
                    arrived.add(newPos);
                }
                newPos = new Pair<>(x, y - 1);
                if (can.contains(newPos) && !arrived.contains(newPos)) {
                    q.add(newPos);
                    arrived.add(newPos);
                }
                newPos = new Pair<>(x, y + 1);
                if (can.contains(newPos) && !arrived.contains(newPos)) {
                    q.add(newPos);
                    arrived.add(newPos);
                }
            }
            step++;
        }
        return step;
    }
}

class Pair<K,V> {
    private K key;
    public K getKey() { return key; }
    private V value;
    public V getValue() { return value; }
    public Pair(K key,V value) {
        this.key = key;
        this.value = value;
    }
    @Override
    public int hashCode() {
        return key.hashCode() * 13 + (value == null ? 0 : value.hashCode());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Pair) {
            Pair pair = (Pair) o;
            if (key != null ? !key.equals(pair.key) : pair.key != null) return false;
            if (value != null ? !value.equals(pair.value) : pair.value != null) return false;
            return true;
        }
        return false;
    }
}