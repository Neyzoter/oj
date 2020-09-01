package cn.neyzoter.exam.pdd.round2;

import java.util.*;

/**
 * pdd测试1
 * AC 70%
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
        int max = soldierTrace(matrix);
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
