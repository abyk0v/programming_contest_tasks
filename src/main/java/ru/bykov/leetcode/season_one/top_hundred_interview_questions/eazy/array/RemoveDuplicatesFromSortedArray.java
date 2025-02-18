package top_hundred_interview_questions.eazy.array;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] nums0 = {};
        int result0 = solve(nums0);
        System.out.printf("result: %d, nums: %s\n", result0, Arrays.toString(nums0));

        int[] nums1 = {1, 1, 2};
        int result1 = solve(nums1);
        System.out.printf("result: %d, nums: %s\n", result1, Arrays.toString(nums1));

        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int result2 = solve(nums2);
        System.out.printf("result: %d, nums: %s\n", result2, Arrays.toString(nums2));

        int[] nums3 = {1};
        int result3 = solve(nums3);
        System.out.printf("result: %d, nums: %s\n", result3, Arrays.toString(nums3));

        int[] nums4 = null;
        int result4 = solve(nums4);
        System.out.printf("result: %d, nums: %s\n", result4, nums4);

    }

    private static int solve(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int uniqueCount = 1;
        int left = 0;
        int right = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[left] == nums[right]) {
                right += 1;
            } else {
                uniqueCount += 1;
                left += 1;

                if (nums[right] != nums[right - 1]) {
                    nums[left] = nums[right];
                }

                right += 1;
            }
        }

        return uniqueCount;
    }
}
