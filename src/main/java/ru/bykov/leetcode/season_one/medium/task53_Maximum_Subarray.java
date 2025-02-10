package ru.bykov.leetcode.season_one.medium;

public class task53_Maximum_Subarray {

    public static void main(String[] args) {
        var task = new task53_Maximum_Subarray();
        System.out.println( "6: " + task.maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}) );
        System.out.println( "1: " + task.maxSubArray(new int[] {1}) );
        System.out.println( "23: " + task.maxSubArray(new int[] {5,4,-1,7,8}) );
    }

    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currenMaxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currenMaxSum = Math.max(currenMaxSum + nums[i], nums[i]);
            if (currenMaxSum > maxSum) maxSum = currenMaxSum;
        }

        return maxSum;
    }

//    Динамическое программирование

//    public int maxSubArray(int[] nums) {
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
//        int maxSum = nums[0];
////        int maxSumIndex = 0;
////        int[] prev = new int[nums.length];
//
//        for (int i = 1; i < nums.length; i++) {
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
//            if (dp[i] > maxSum) maxSum = dp[i];
//        }
//
//        return maxSum;
//    }
}
