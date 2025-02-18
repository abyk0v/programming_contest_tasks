package top_hundred_interview_questions.eazy.array;

import java.util.Arrays;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums0 = {0,1,0,3,12};
        int[] result0 = solve(nums0);
        System.out.printf("1. expected: [1,3,12,0,0], result: %s\n", Arrays.toString(result0));

        int[] nums1 = {0};
        int[] result1 = solve(nums1);
        System.out.printf("2. expected: [0], result: %s\n", Arrays.toString(result1));

    }

    /** O(2n) => O(n) */
    private static int[] solve(int[] nums) {
        int headIndex = 0;
        int currentIndex = 0;
        do {
            if (nums[currentIndex] != 0) {
                nums[headIndex] = nums[currentIndex];
                headIndex += 1;
            }
            currentIndex += 1;

        } while (currentIndex < nums.length);

        for (int i = headIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
        return nums;
    }
}
