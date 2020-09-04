package cn.neyzoter.exam.baidu;

import java.util.*;

/*
2
10 2
3
1 2
4 5
8 8
2
1 4
6 8
10 2
3
1 2
4 5
8 8
2
1 4
6 8

输出
4
1 2 4 8
4
1 2 4 8
 */
/**
 * Test2
 * AC 0% 超时
 * @author neyzoter
 */
public class Test2 {
    public static void main(String[] args) {
        int[][] a = {{1,2}};
        int[][] b = {{3,4}};
        int[][] iis = intervalIntersection(a, b);
        System.out.println(iis.length);
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (;T > 0; T--) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            Queue<int[][]> list = new ArrayDeque<>();
            for (int i = 0; i < m; i++) {
                int k = sc.nextInt();
                int[][] arr = new int[k][2];
                for (int j = 0; j < k; j++) {
                    arr[j][0] = sc.nextInt();
                    arr[j][1] = sc.nextInt();
                }
                list.add(arr);
            }
            boolean ctn = false;
            for (;list.size() >= 2; ) {
                int[][] arr1 = list.poll();
                int[][] arr2 = list.poll();
                int[][] res = intervalIntersection(arr1, arr2);
                if (res.length != 0) {
                    list.add(res);
                } else {
                    System.out.println(0);
                    ctn = true;
                    break;
                }
            }
            if (ctn) {
                continue;
            }
            if (list.size() == 0) {
                System.out.println(0);
                break;
            }
            int[][] res = list.peek();
            int sum = 0;
            for (int[] r : res) {
                sum += r[1] - r[0] + 1;
            }
            System.out.println(sum);
            for (int ri = 0; ri < res.length; ri++) {
                int[] r = res[ri];
                for (int s = r[0]; s <= r[1]; s++) {
                    System.out.print(s);
                    if (! (ri + 1 >= res.length && s + 1 > r[1])) {
                        System.out.print(" ");
                    }
                }
            }
            if (sum != 0) {
                System.out.println();
            }
        }
    }

    /**
     * 区间交集
     * @param A 按照第0个数字排序的二维数组
     * @param B 按照第0个数字排序的二维数组
     * @return 区间交集，如果无交集则返回长度为0的数组
     */
    public static int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> ans = new ArrayList<>();
        int i = 0, j = 0;
        while (i < A.length && j < B.length) {
            int l = Math.max(A[i][0], B[j][0]);
            int h = Math.min(A[i][1], B[j][1]);
            if (l <= h) {
                ans.add(new int[]{l, h});
            }
            if (A[i][1] < B[j][1]) {
                i++;
            } else {
                j++;
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}
