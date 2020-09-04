package cn.neyzoter.exam.pdd.round2;

import java.util.*;

/**
 * pdd测试2
 * AC 70%
 * 4 4
 * 1 0 1 1
 * 1 1 0 1
 * 0 0 0 0
 * 1 1 1 1
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        Sol1Plus sol1Plus = new Sol1Plus(matrix);
        int max = sol1Plus.soldierTrace();
//        int max = soldierTrace(matrix);
        System.out.println(max);
    }

    public static int soldierTrace(int[][] matrix) {
        HashMap<Integer, Set<String>> pos = new HashMap<>();
        boolean[][] arrived = new boolean[matrix.length][matrix[0].length];
        Set<String> idx = new HashSet<>();
        int posIdx = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (!arrived[i][j] && matrix[i][j] == 1) {
                    soldierTraceFrom(idx, matrix, arrived, i, j);
                    if (!idx.isEmpty()) {
                        pos.put(posIdx++, idx);
                        idx = new HashSet<>();
                    }
                }
            }
        }
        if (pos.size() == 0) {
            return 0;
        } else if (pos.size() == 1) {
            return pos.get(0).size();
        }
        Collection<Set<String>> set = pos.values();
        int max = 0;
        for (Set<String> s : set) {
            max = Math.max(s.size(), max);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = 1;
                    arrived = new boolean[matrix.length][matrix[0].length];
                    int sum = soldierTraceFrom(matrix, arrived, i, j);
                    if (pos.size() == 2) {
                        sum--;
                    }
                    max = Math.max(sum, max);
                    matrix[i][j] = 0;
                }
            }
        }
        return max;
    }
    public static boolean isSoldier(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == 1;
    }

    public static void soldierTraceFrom(Set<String> pos, int[][] matrix, boolean[][] arrived, int x, int y) {
        if (!(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length)) {
            return;
        }
        if ((matrix[x][y] == 0 || arrived[x][y])) {
            return;
        }
        arrived[x][y] = true;
        pos.add(getPosStr(x, y));
        soldierTraceFrom(pos, matrix, arrived, x + 1, y);
        soldierTraceFrom(pos, matrix, arrived, x, y + 1);
        soldierTraceFrom(pos, matrix, arrived, x - 1, y);
        soldierTraceFrom(pos, matrix, arrived, x, y - 1);
    }

    public static int soldierTraceFrom(int[][] matrix, boolean[][] arrived, int x, int y) {
        if (!(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length)) {
            return 0;
        }
        if (matrix[x][y] == 0 || arrived[x][y]) {
            return 0;
        }
        arrived[x][y] = true;
        return 1 + soldierTraceFrom(matrix, arrived, x + 1, y) +
        soldierTraceFrom(matrix, arrived, x, y + 1) +
        soldierTraceFrom(matrix, arrived, x - 1, y) +
        soldierTraceFrom(matrix, arrived, x, y - 1);
    }

    public static String getPosStr(int i, int j) {
        return String.format("%d_%d", i, j);
    }
}

class Sol1Plus {
    int[][] matrix;
    public Sol1Plus(int[][] m) {
        this.matrix = m;
    }
    public int soldierTrace() {
        int num = 0;
        int max = 0;
        // <岛屿编号, 岛屿内数量>
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                int n = soldierTraceFrom(matrix, num + 1, i, j);
                if (n != 0) {
                    max = Math.max(max, n);
                    num += 1;
                    map.put(num + 1, n);
                }
            }
        }
        if (map.size() <= 1) {
            return max;
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][j] = num + 2;
                    boolean[][] arrived = new boolean[matrix.length][matrix[0].length];
                    Set<Integer> idx = new HashSet<>();
                    int sum = soldierTraceFrom(matrix, idx, arrived, i, j);
                    // idx有num + 2，需要剔除
                    if (map.size() - idx.size() + 1 <= 0) {
                        sum--;
                        System.out.println(map.size() + " " + idx.size());
                    }
                    max = Math.max(sum, max);
                    matrix[i][j] = 0;
                }
            }
        }
        return max;
    }

    public int soldierTraceFrom(int[][] matrix, int add, int x, int y) {
        assert add > 0;
        if (!valid(matrix, x, y)) {
            return 0;
        }
        if (matrix[x][y] != 1) {
            return 0;
        }
        // 等于1则进行改变
        // 增加add，使得一个岛屿的编号相同
        matrix[x][y] += add;
        return 1 + soldierTraceFrom(matrix, add, x + 1, y) +
                soldierTraceFrom(matrix, add, x, y + 1) +
                soldierTraceFrom(matrix, add, x - 1, y) +
                soldierTraceFrom(matrix, add, x, y - 1);
    }
    public int soldierTraceFrom(int[][] matrix, Set<Integer> set, boolean[][] arrived, int x, int y) {
        if (!valid(matrix, x, y)) {
            return 0;
        }
        if (matrix[x][y] == 0 || arrived[x][y]) {
            return 0;
        }
        arrived[x][y] = true;
        // 添加到set，用于后期来看链接了多少个岛屿
        set.add(matrix[x][y]);
        return 1 + soldierTraceFrom(matrix, set, arrived, x + 1, y) +
                soldierTraceFrom(matrix, set, arrived, x, y + 1) +
                soldierTraceFrom(matrix, set, arrived, x - 1, y) +
                soldierTraceFrom(matrix, set, arrived, x, y - 1);
    }

    public boolean valid(int[][] matrix, int x, int y) {
        return x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length;
    }
}
