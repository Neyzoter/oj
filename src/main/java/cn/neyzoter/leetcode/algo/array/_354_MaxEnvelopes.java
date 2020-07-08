package cn.neyzoter.leetcode.algo.array;

/**
 * 354. 俄罗斯套娃信封问题
 * @author Charles Song
 * @date 2020-7-8
 */
public class _354_MaxEnvelopes {
    public static void main(String[] args) {
        int[][] e = {{5,4},{6,4},{6,7},{6,5},{3,4}};
        Sol1_354_MaxEnvelopes.sort(e, 0, e.length - 1, 0);
        int base = 0;
        for (int i = 1; i < e.length; i ++) {
            if (e[base][0] != e[i][0] || (i == e.length - 1)) {
                if (i - base >= 2) {
                    Sol1_354_MaxEnvelopes.sort(e, base, e[base][0] != e[i][0] ? i - 1 : i, 1);
                }
                base ++;
            }
        }
    }
}
class Sol1_354_MaxEnvelopes {
    public int maxEnvelopes(int[][] envelopes) {
        return 1;
    }

    public static int[][] sort(int[][] envelopes,int s, int e, int idx) {
        if (e - s < 1) {
            return envelopes;
        }
        int left, right;
        int base = envelopes[s][idx];
        int[] baseVal = new int[envelopes[0].length];
        for (int i = 0; i < baseVal.length; i ++) {
            baseVal[i] = envelopes[s][i];
        }
        for (left = s + 1, right = s + 1;right <= e; right++) {
            System.out.println(String.format("right = %d", right));
            if (envelopes[right][idx] < base) {
                swap(envelopes[left], envelopes[right]);
                left++;
            }
        }
        int sl = s + 1;int sr = left - 1;
        int bl = left;int br = e;

        sort(envelopes, sl, sr, idx);
        sort(envelopes, bl, br, idx);
        for (int i = s; i < sr; i ++) {
            envelopes[i][0] = envelopes[i + 1][0];
            envelopes[i][1] = envelopes[i + 1][1];
        }
        envelopes[sr][0] = baseVal[0];envelopes[sr][1] = baseVal[1];
        return envelopes;
    }

    public static void swap(int[] arr1, int[] arr2){
        int[] temp = arr1.clone();
        for (int i = 0; i < arr1.length; i ++) {
            arr1[i] = arr2[i];
            arr2[i] = temp[i];
        }
    }
}