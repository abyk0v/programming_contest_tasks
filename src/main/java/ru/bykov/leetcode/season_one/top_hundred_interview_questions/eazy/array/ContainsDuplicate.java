package top_hundred_interview_questions.eazy.array;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums0 = {1,2,3,1};
        boolean result0 = solve(nums0);
        System.out.printf("1. expected: true, result: %b\n", result0);

        int[] nums1 = {1,2,3,4};
        boolean result1 = solve(nums1);
        System.out.printf("1. expected: false, result: %b\n", result1);

        int[] nums2 = {1,1,1,3,3,4,3,2,4,2};
        boolean result2 = solve(nums2);
        System.out.printf("1. expected: true, result: %b\n", result2);

    }

    /** Реализация с TreeSet-от в 4-е раза меделеннее
     *
     * complexity: О(n) + O(1) + O(logN) => O(n logN)
     * memory: O(n)
     * */
    private static boolean solve(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
