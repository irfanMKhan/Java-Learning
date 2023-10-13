package com.topic.leetcode;

public class L_121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int minValue = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minValue) {
                minValue = prices[i];
            }
            if ((prices[i] - minValue) > maxProfit) {
                maxProfit = prices[i] - minValue;
            }
        }

        return maxProfit;

    }
}
