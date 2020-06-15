package cn.neyzoter.leetcode.algo.array;

/**
 * 121. 买卖股票的最佳时机
 * @author Charles Song
 * @date 2020-6-15
 */
public class _121_MaxProfit {
    public static void main (String[] args) {
        int[] price = {7,1,5,3,6,4};
        Sol2_MaxProfit sol = new Sol2_MaxProfit();
        System.out.println(sol.maxProfit(price));
    }
}

class Sol1_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int sum = 0;
        for (int i = prices.length - 2; i >= 0; i --) {
            int delta = prices[prices.length - 1] - prices[i];
            if (delta > sum) {
                sum = delta;
            }
            swap(i, prices);
        }
        return sum;
    }

    public static void swap (int start, int[] arr) {
        if (start > arr.length - 2 || arr[start] <= arr[start + 1]) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[start + 1];
        arr[start + 1] = temp;
        swap(start + 1, arr);
    }
}

class Sol2_MaxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        int sum = 0;
        int max = 0;
        for (int i = prices.length - 1; i >= 0; i --) {
            int delta = max - prices[i];
            if (delta > sum) {
                sum = delta;
            }
            max = max < prices[i] ? prices[i] : max;
        }
        return sum;
    }
}
