package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.dynamic_programming;

public class MaximumSubarray {

    public static void main(String[] args) {
        MaximumSubarray test = new MaximumSubarray();

        int[] nums = new int[] {1,2,-1,-2,2,1,-2,1,4,-5,4};
        System.out.println("6: " + test.maxSubArray_(nums));

    }

    // С помощью dp
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];

        for (int i=1; i<nums.length; i++) {
            if (dp[i-1] + nums[i] > nums[i]) {
                dp[i] = dp[i-1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            if (dp[i] > maxSum) {
                maxSum = dp[i];
            }
        }

        return maxSum;
    }

    // С помощью dp (без массива)
    public int maxSubArray_withoutArray(int[] nums) {
        int dp_last = nums[0];
        int dp_i;
        int maxSum = nums[0];

        for (int i=1; i<nums.length; i++) {
            if ((dp_last + nums[i]) > nums[i]) {
                dp_i = dp_last + nums[i];
            } else {
                dp_i = nums[i];
            }

            if (dp_i > maxSum) {
                maxSum = dp_i;
            }
        }

        return maxSum;
    }

    // С помощью двух указателей (скользящего окна)
    public int maxSubArray_(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int l = 0;
        int r = 0;
        int sum = nums[0];
        int maxSum = sum;

        while (l < nums.length-1 || r < nums.length-1) {
            if (l == r) {
                sum = sum + nums[r+1];
                r += 1;

                if (maxSum < sum) {
                    maxSum = sum;
                }
                continue;
            }

            if (l < nums.length - 1 && r == nums.length - 1) {
                sum = sum - nums[l];
                l += 1;

                if (maxSum < sum) {
                    maxSum = sum;
                }
                continue;
            }

            if (l < nums.length - 1 && r < nums.length - 1) {
                int newSumMoveRight = sum + nums[r+1];
                int newSumMoveLeft = sum - nums[l];
                if (newSumMoveRight > newSumMoveLeft) {
                    r += 1;
                    sum = newSumMoveRight;
                } else {
                    l += 1;
                    sum = newSumMoveLeft;
                }
            }

            if (maxSum < sum) {
                maxSum = sum;
            }
        }
        return maxSum;
    }
}
