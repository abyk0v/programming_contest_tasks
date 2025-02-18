package yandex_mock_interview;

import java.util.Arrays;

public class SqrtArray {

    public static void main(String[] args) {
        int[] array = { -3, 2, 4 };
        int[] result = solve2(array);
        System.out.println(Arrays.toString(result));

        int[] array1 = { 2 };
        int[] result1 = solve2(array1);
        System.out.println(Arrays.toString(result1));

        int[] array2 = { -7, -5, -3 };
        int[] result2 = solve2(array2);
        System.out.println(Arrays.toString(result2));

        int[] array3 = { 2, 4, 8 };
        int[] result3 = solve2(array3);
        System.out.println(Arrays.toString(result3));
    }

    /**
     *  Time complexity: O(2n)
     *  Memory: O(n + 3)
     */
    public static int[] solve(int[] array) {
        if (array == null || array.length == 0) {
            return array;
        }

        int negativeIndex = -1, positiveIndex = array.length;
        for (int i = 0; i < array.length-1; i++) {
            if (array[i] < 0 && array[i+1] >= 0) {
                negativeIndex = i;
                positiveIndex = i + 1;
                break;
            }
        }
        if (negativeIndex == -1 && positiveIndex == array.length) {
            if (array[0] >= 0) {
                positiveIndex = 0;
            } else {
                negativeIndex = array.length-1;
            }
        }


        int[] result = new int[array.length];
        int resultIndex = 0;
        while (negativeIndex >= 0 || positiveIndex < array.length) {
            if (negativeIndex == -1) {
                while (positiveIndex < array.length) {
                    result[resultIndex] = array[positiveIndex] * array[positiveIndex];
                    positiveIndex += 1;
                    resultIndex += 1;
                }
                break;
            }
            if (positiveIndex == array.length) {
                while (negativeIndex >= 0) {
                    result[resultIndex] = array[negativeIndex] * array[negativeIndex];
                    negativeIndex -= 1;
                    resultIndex += 1;
                }
                break;
            }

            if (Math.abs(array[negativeIndex]) > array[positiveIndex]) {
                result[resultIndex] = array[negativeIndex] * array[negativeIndex];
                negativeIndex -= 1;
            } else {
                result[resultIndex] = array[positiveIndex] * array[positiveIndex];
                positiveIndex += 1;
            }
            resultIndex += 1;
        }
        return result;
    }

    /**
     *  Time complexity: O(n)
     *  Memory: O(n + 3)
     */
    public static int[] solve2(int[] array) {
        int left = 0;
        int right = array.length-1;
        int[] result = new int[array.length];
        int resultIndex = array.length-1;

        while (left <= right) {
//        while (true) {
//            if (left == right) {
//                result[resultIndex] = array[right] * array[right];
//                break;
//            }

            if (Math.abs(array[left]) > Math.abs(array[right])) {
                result[resultIndex] = array[left] * array[left];
                left++;
            } else {
                result[resultIndex] = array[right] * array[right];
                right--;
            }
            resultIndex--;
        }
        return result;
    }
}
