package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.dynamic_programming;

public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

    }

    /*
    cpu: O(N)
    memory: O(1)
     */
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }

        int pastMinPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i=1; i<prices.length; i++) {
            // Обновляем pastMinPrice
            if (prices[i-1] < pastMinPrice) {
                pastMinPrice = prices[i-1];
            }
            // обновляем max-ый профит
            int profit = prices[i] - pastMinPrice;
            if (maxProfit < profit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }
}
