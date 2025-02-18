package top_hundred_interview_questions.eazy.array;

import java.util.HashSet;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums0 = {2, 2, 1};
        int result0 = solve(nums0);
        System.out.printf("1. expected: 1, result: %d\n", result0);

        int[] nums1 = {4, 1, 2, 1, 2};
        int result1 = solve(nums1);
        System.out.printf("1. expected: 4, result: %d\n", result1);

    }

    /** Решение с использованием Set-а */
    private static int solve(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int item: nums) {
            if (!set.add(item)) {
                set.remove(item);
            }
        }
        return (Integer) set.toArray()[0];
    }
}
