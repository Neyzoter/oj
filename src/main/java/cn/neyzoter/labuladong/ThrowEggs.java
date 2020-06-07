package cn.neyzoter.labuladong;

import java.util.HashMap;

/**
 * 高楼扔鸡蛋问题<br/>
 * 887. 鸡蛋掉落
 * @author Charles Song
 * @date 2020-6-7
 */
public class ThrowEggs {
    public static HashMap<String, Integer> map = new HashMap<>();
    public static void main (String[] args) {
        int num = superEggDrop2(3, 14);
        System.out.println(num);
    }

    /**
     * 超时
     * @param N 楼高
     * @param K 鸡蛋个数
     * @return 最少仍鸡蛋次数
     */
    public static int superEggDrop (int K,int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        String key = getKey(K, N);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = N;
        for (int i = 1; i < N + 1; i ++) {
            // 鸡蛋碎了
            int broken = superEggDrop(K - 1, i - 1);
            // 鸡蛋未碎
            int notBroken = superEggDrop(K,N - i);
            // 最坏情况下(max)，最少扔鸡蛋的次数
            res = Math.min(res, Math.max(broken, notBroken) + 1);
        }
        // 缓存
        map.put(key, res);
        return res;
    }

    /**
     * 优化版本，线性查找转化为二分查找<br/>
     * 能用二分搜索是因为状态转移方程的函数图像具有单调性,可以快速找到最值。
     * @param K
     * @param N
     * @return
     */
    public static int superEggDrop2 (int K,int N) {
        if (K == 1) {
            return N;
        }
        if (N == 0) {
            return 0;
        }
        String key = getKey(K, N);
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int res = N;
        int left = 1, right = N;
        while (left <= right) {
            int mid = (left + right) / 2;
            int broken = superEggDrop(K - 1, mid - 1);
            int notBroken = superEggDrop(K,N - mid);
            if (broken > notBroken) {
                res = Math.min(res, broken + 1);
                right = mid - 1;
            } else {
                res = Math.min(res, notBroken + 1);
                left = mid + 1;
            }
        }
        map.put(key, res);
        return res;
    }

    public static String getKey (int K,int N) {
        return String.format("%d_%d", K, N);
    }
}
