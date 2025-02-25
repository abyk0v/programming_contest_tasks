package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.dynamic_programming;

public class HouseRobber {

    public static void main(String[] args) {
        HouseRobber test = new HouseRobber();
        System.out.println("4: " + test.rob(new int[] {1,2,3,1}));
    }

    /*
    time: O(N)
    memory: O(N)
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int maxProof = Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        dp[2] = nums[2] + nums[0];
        maxProof = Math.max(maxProof, dp[2]);

        for (int i=3; i<nums.length; i++) {
            dp[i] = Math.max(dp[i-2], dp[i-3]) + nums[i];
            if (dp[i] > maxProof) {
                maxProof = dp[i];
            }
        }
        return maxProof;
    }
}
