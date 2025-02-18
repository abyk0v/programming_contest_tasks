package top_hundred_interview_questions.eazy.array;

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums0 = {2,7,11,15};
        int target0 = 9;
        int[] result0 = solve(nums0, target0);
        System.out.printf("1. expected: [0,1], result: %s\n", Arrays.toString(result0));

        int[] nums1 = {3,2,4};
        int target1 = 6;
        int[] result1 = solve(nums1, target1);
        System.out.printf("2. expected: [1,2], result: %s\n", Arrays.toString(result1));

        int[] nums2 = {3,3};
        int target2 = 6;
        int[] result2 = solve(nums2, target2);
        System.out.printf("3. expected: [0,1], result: %s\n", Arrays.toString(result2));

    }

    /** O(n^2/2) => o(n^2) */
    private static int[] solve(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[2];
    }
}
