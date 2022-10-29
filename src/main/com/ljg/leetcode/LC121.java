package main.com.ljg.leetcode;

public class LC121 {
    /**
     * 我的解法，更新每次扫描到的利润，如果成本比原成本低就更新。
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int cost = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            maxProfit =  Math.max(maxProfit, prices[i] - cost);
            cost = Math.min(cost, prices[i]);
        }
        return maxProfit;
    }
}
