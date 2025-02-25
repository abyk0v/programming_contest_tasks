package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.dynamic_programming;

public class ClimbingStairs {

    public static void main(String[] args) {
        ClimbingStairs test = new ClimbingStairs();

        System.out.println("1: " + test.climbStairs(1));
        System.out.println("2: " + test.climbStairs(2));
        System.out.println("3: " + test.climbStairs(3));
        System.out.println("5: " + test.climbStairs(4));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }

        return solve(n, dp);
    }

    private int solve(int n, int[] dp) {
        if (n == 0 || dp[n] != 0) {
            return dp[n];
        } else {
            dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
            return dp[n];
        }
    }

    public int climbStairs2(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        if (n > 1) {
            dp[2] = 2;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
