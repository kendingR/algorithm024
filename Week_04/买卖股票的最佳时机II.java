package com.ken.贪心;

public class 买卖股票的最佳时机II {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,6,2,1,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i > 0 && prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}
