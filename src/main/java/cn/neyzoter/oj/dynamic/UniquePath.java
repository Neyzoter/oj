package cn.neyzoter.oj.dynamic;

/**
 * 62 不同路径
 */
public class UniquePath {
    public static void main(String[] args){
        Solution1_UniquePath solution1_uniquePath = new Solution1_UniquePath();
        System.out.println(solution1_uniquePath.uniquePaths(1,3));
    }
}

/**
 * 递归法，会超时
 */
class Solution1_UniquePath {
    public static int cnt = 0;
    public int uniquePaths(int m, int n) {
        cnt = 0;
        if (m == 1 || n == 1) {
            cnt = 1;
            return cnt;
        }else {
            return pathCounter(m - 1,n - 1);
        }
    }
    private int pathCounter (int m, int n) {
        if (m > 0) {
            pathCounter(m - 1, n);
        }
        if (n > 0) {
            pathCounter(m, n - 1);
        }
        if (m == 0 && n == 0) {
            cnt ++;
        }
        return cnt;
    }
}
