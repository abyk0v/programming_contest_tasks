package top_hundred_interview_questions.eazy.array;

public class BestTimeToBuyAndSellStock_II {

    public static void main(String[] args) {
//        int[] prices0 = {7, 1, 5, 3, 6, 4};
//        int profit0 = solve(prices0);
//        System.out.printf("1. expected: 7, result: %d\n", profit0);
//
//        int[] prices1 = {10};
//        int profit1 = solve(prices1);
//        System.out.printf("2. expected: 0, result: %d\n", profit1);

        int[] prices2 = {1,2,3,4,5};
        int profit2 = solve(prices2);
        System.out.printf("3. expected: 4, result: %d\n", profit2);
    }

    private static int solve(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        boolean isHoldStock = false;
        int profit = 0;
        for (int i = 0; i < prices.length; i++) {
            int left = i > 0 ? prices[i-1] : prices[0];
            int current = prices[i];
            int right = i < prices.length-1 ? prices[i+1] : Integer.MIN_VALUE;

            if (isHoldStock) { // держим акцию
                if (left <= current && current > right) {
                    profit += prices[i];
                    isHoldStock = false;
                }
            } else { // не держим акцию
                if (left >= current && current < right) {
                    profit -= prices[i];
                    isHoldStock = true;
                }
            }
        }

        return Math.max(profit, 0);
    }
}
