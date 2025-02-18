package yandex_mock_interview;

import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * [ [1, 3], [2,8], [10,15] ]
 *
 *     * ....... *
 *            *.......*
 *
 */

public class IntervalTask {

    public static void main(String[] args) {
        // 1
        int[][] request = { {10,15}, {1, 3}, {2,8} };
        int[][] answer = solve(new int[1][1]);
        printAnswer(answer);
    }

    private static int[][] solve(int[][] array) {
        // граничные условия
        if (array == null || array.length == 0) {
            return new int[1][1];
        }

        Arrays.sort(array, Comparator.comparingInt(interval -> interval[0]));
        int lastItem = 0;
        int[][] result = new int[array.length][2];
        result[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (result[lastItem][1] >= array[i][0]) {
                result[lastItem][1] = Math.max(result[lastItem][1], array[i][1]);
            } else {
                lastItem++;
                result[lastItem] = array[i];
            }
        }

        return lastItem+1 != result.length ? Arrays.copyOf(result, lastItem+1) : result;
    }

    private static void printAnswer(int[][] answer) {
        System.out.print("[ ");
        for (int[] ints : answer) {
            System.out.printf("[%d, %d] ", ints[0], ints[1]);
        }
        System.out.println("]");
    }
}
