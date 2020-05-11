package cn.neyzoter.oj.array;

/**
 * https://zhuanlan.zhihu.com/p/83334559
 */
public class KMP {
    private int[][] dp;
    private String pat;

    public static void main (String[] args) {
        String str1 = "ababa";
        String str2 = "12daaaaababacd";
        KMP kmp = new KMP(str1);
        int idx = kmp.search(str2);
        System.out.println(idx);

        System.out.println(Kmps.getIndex(str2,str1));
    }
    public KMP(String pat) {
        this.pat = pat;
        int M = pat.length();
        // dp[状态][字符] = 下个状态
        dp = new int[M][256];
        // base case
        dp[0][pat.charAt(0)] = 1;
        // 影子状态 X 初始为 0
        int X = 0;
        // 构建状态转移图（稍改的更紧凑了）
        for (int j = 1; j < M; j++) {
            for (int c = 0; c < 256; c++) {
                dp[j][c] = dp[X][c];
            }
            // 推进
            dp[j][pat.charAt(j)] = j + 1;
            // 更新影子状态
            X = dp[X][pat.charAt(j)];
        }
    }
    public int search (String txt){
        int M = pat.length();
        int N = txt.length();
        // pat 的初始态为 0
        int j = 0;
        for (int i = 0; i < N; i++) {
            // 计算 pat 的下一个状态
            j = dp[j][txt.charAt(i)];
            // 到达终止态，返回结果
            if (j == M) {
                return i - M + 1;
            }
        }
        // 没到达终止态，匹配失败
        return -1;
    }
}

class Kmps {
    /**
     * 获取next数组（状态机）
     * @param ps 字符串
     * @return next数组
     */
    private static int[] getNext(String ps) {
        char[] p = ps.toCharArray();
        int[] next = new int[p.length];
        next[0] = -1;
        int j = 0;
        int k = -1;
        while (j < p.length - 1) {
            // 情况1,p[j] == p[k]，next是往后推进的
            if (k == -1 || p[j] == p[k]) {
                next[++j] = ++k;
            // 情况2,p[j] != p[k]，k需要回退
            } else {
                k = next[k];
            }
        }
        return next;
    }

    /**
     * str2在str1的起始位置
     * @param str1 字符串2
     * @param str2 字符串1
     * @return str2在str1的起始位置
     */
    public static int getIndex (String str1, String str2) {
        int[] next = getNext(str2);
        int i = 0, j = 0;
        for (; i < str1.length() && j < str2.length(); ) {
            char ch1 = str1.charAt(i);
            char ch2 = str2.charAt(j);
            if (ch1 != ch2) {
                if (next[j] < 0) {
                    i ++;
                } else {
                    j = next[j];
                }

            } else {
                j ++;
                i ++;
            }
        }
        if (j >= str2.length()) {
            return i - str2.length();
        } else {
            return -1;
        }
    }
}