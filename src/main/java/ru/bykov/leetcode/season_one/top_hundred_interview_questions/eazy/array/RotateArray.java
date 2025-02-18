package top_hundred_interview_questions.eazy.array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        System.out.println(10 % 7);

        int[] nums0 = {1,2,3,4,5,6,7};
        solve(nums0, 3);
        System.out.printf("1. expected: [5,6,7,1,2,3,4], result: %s\n", Arrays.toString(nums0));
    }

    /** Решение с копированием смешенного елемента в новый массив
     *
     * complexity: О(2n) => O(n)
     * memory: O(n)
     * */
    private static void solve(int[] nums, int k) {
        int factor = k % nums.length;

        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int newIndex = factor + i;
            if (newIndex >= nums.length) {
                newIndex -= nums.length;
            }

            newNums[newIndex] = nums[i];
        }

        System.arraycopy(newNums, 0, nums, 0, newNums.length);
//        for (int i = 0; i < newNums.length; i++) {
//            nums[i] = newNums[i];
//        }
    }

    /** Отвечае на вапрос: какой елемент долженстоять на данном месте?
     *
     * complexity: О(n)
     * memory: O(1)
     * */
    private static void solveSecond(int[] nums, int k) {
//        int factor = k % nums.length;
//
//        for (int i = 0; i < nums.length; i++) {
//            int newIndex = factor + i;
//            if (newIndex >= nums.length) {
//                newIndex -= nums.length;
//            }
//
//            int whoIsHere = 1;
//
//            int tmp = nums[];
//            nums[i] = nums
//
//
//        }
    }
}
