package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.sorting_and_searching;

import java.util.Arrays;

public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray test = new MergeSortedArray();

        int[] nums1 = new int[] {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = new int[] {2,5,6};
        int n = 3;
        test.merge2(nums1, m, nums2, n);
        System.out.println(
                "Expected: [1,2,2,3,5,6], Output: " +
                Arrays.toString(nums1)
        );
    }

    /*
    time: O(n+m)
    memory: O(n+m)
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] answer = new int[n+m];

        int pointAnswer = 0;
        int point1 = 0;
        int point2 = 0;

        while (point1 != m || point2 != n) {
            if (point1 == m) {
                answer[pointAnswer] = nums2[point2];
                point2 += 1;
                pointAnswer += 1;
                continue;
            }
            if (point2 == n) {
                answer[pointAnswer] = nums1[point1];
                point1 += 1;
                pointAnswer += 1;
                continue;
            }

            if (nums1[point1] <= nums2[point2]) {
                answer[pointAnswer] = nums1[point1];
                point1 += 1;
                pointAnswer += 1;
            } else {
                answer[pointAnswer] = nums2[point2];
                point2 += 1;
                pointAnswer += 1;
            }
        }

        System.arraycopy(answer, 0, nums1, 0, answer.length);
    }

    /*
    time: O(n+m)
    memory: O(1)
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int pointLastNums1 = m - 1;
        int pointLastNums2 = n - 1;
        int pointInsert = m + n - 1;

        while (pointLastNums1 >= 0 || pointLastNums2 >= 0) {
            if (pointLastNums1 < 0) {
                nums1[pointInsert] = nums2[pointLastNums2];
                pointLastNums2 -= 1;
                pointInsert -= 1;
                continue;
            }

            if (pointLastNums2 < 0) {
                nums1[pointInsert] = nums1[pointLastNums1];
                pointLastNums1 -= 1;
                pointInsert -= 1;
                continue;
            }

            if (nums1[pointLastNums1] >= nums2[pointLastNums2]) {
                nums1[pointInsert] = nums1[pointLastNums1];
                pointLastNums1 -= 1;
                pointInsert -= 1;
            } else {
                nums1[pointInsert] = nums2[pointLastNums2];
                pointLastNums2 -= 1;
                pointInsert -= 1;
            }
        }
    }
}
