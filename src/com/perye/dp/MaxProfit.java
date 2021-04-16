package com.perye.dp;

/**
 * 剑指 Offer 63. 股票的最大利润
 * 动态规划
 * 链接：https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
 *
 * @author honggd
 */
public class MaxProfit {


    /**
     * dp
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int cost = Integer.MAX_VALUE, profit = 0;
        for(int price : prices) {
            cost = Math.min(cost, price);
            profit = Math.max(profit, price - cost);
        }
        return profit;
    }

    /**
     * 暴力法
     * @param prices
     * @return
     */
    public static int maxProfit2(int[] prices) {
        int ans = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                ans = Math.max(ans, prices[j] - prices[i]);
            }
        }
        return ans;
    }


}
