package cn.neyzoter.sword;


import java.util.HashMap;

/**
 * 面试题10- I. 斐波那契数列 fibonacci问题
 * @author Charles Song
 * @date 2020-5-26
 */
public class Fibonacci {
    public static void main (String[] args) {
        int n = 5;
        System.out.println(DirectFib(n));
        System.out.println(CutFib(n));
    }

    private static int DirectFib (int n) {
        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        return DirectFib(n - 1) + DirectFib(n - 2);
    }

    private static int CutFib (int n) {
        class Helper {
            private int helper (HashMap<Integer, Integer> map, int n) {
                if (n <= 0) {
                    return 0;
                } else if (n <= 2) {
                    return 1;
                }
                if (map.containsKey(n)) {
                    return map.get(n);
                } else {
                    int var = helper(map, n - 1) + helper(map, n - 2);
                    if (var >= 1000000007) {
                        var -= 1000000007;
                    }
                    map.put(n, var);
                    return map.get(n);
                }
            }
        }
        return new Helper().helper(new HashMap<>(n), n);
    }
}
