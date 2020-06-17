package cn.neyzoter.leetcode.algo.array;

/**
 * 122. 买卖股票的最佳时机 II
 * @author Charles Song
 * @date 2020-6-17
 */
public class _122_MaxProfit {
    public static void main (String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};
        Sol3_MaxProfit sol = new Sol3_MaxProfit();
        System.out.println(sol.maxProfit(prices2));
    }
}

class Sol3_MaxProfit {
    public int maxProfit(int[] prices) {
        int start, end;
        if (prices.length == 0) {
            return 0;
        } else {
            start = prices[0];
            end = prices[0];
        }
        int sum = 0;
        for (int i = 0; i < prices.length; i ++) {
            if (prices[i] >= end) {
                end = prices[i];
                if (i == prices.length - 1) {
                    sum += end - start;
                }
            } else {
                int delta = end - start;
                end = prices[i];
                start = prices[i];
                sum += delta;
            }
        }
        return sum;
    }
}
