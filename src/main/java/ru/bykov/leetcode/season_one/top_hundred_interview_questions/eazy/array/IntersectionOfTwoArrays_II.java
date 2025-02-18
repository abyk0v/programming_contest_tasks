package top_hundred_interview_questions.eazy.array;

import java.util.Arrays;

public class IntersectionOfTwoArrays_II {

    public static void main(String[] args) {
        int[] nums0_1 = {1, 2, 2, 1};
        int[] nums0_2 = {2, 2};
        int[] result0 = solve(nums0_1, nums0_2);
        System.out.printf("1. expected: [2,2], result: %s\n", Arrays.toString(result0));

        int[] nums1_1 = {4,9,5};
        int[] nums1_2 = {9,4,9,8,4};
        int[] result1 = solve(nums1_1, nums1_2);
        System.out.printf("1. expected: [4,9], result: %s\n", Arrays.toString(result1));

    }

    /** O (NlogN + NlogN + N) => O(2NlogN + N) => O(NlogN + N) в среднем */
    private static int[] solve(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); // O(N logN)
        Arrays.sort(nums2); // O(N logN)

        int[] intersection = new int[Math.max(nums1.length, nums2.length)];
        int j = 0, i = 0, intersectionIndex = 0;
        do { // O(N)
            if (nums1[i] == nums2[j]) {
                intersection[intersectionIndex] = nums1[i];
                intersectionIndex += 1;
            }

            int old_i = i;
            if (i < nums1.length && nums1[i] <= nums2[j]) {
                i++;
            }

            if (j < nums2.length && nums2[j] <= nums1[old_i]) {
                j++;
            }

        } while (i != nums1.length && j != nums2.length);

        return Arrays.copyOfRange(intersection, 0, intersectionIndex);
    }
}
