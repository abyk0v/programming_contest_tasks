package ru.bykov.tinkoff.interview;

import java.util.Arrays;

public class task1 {
    public static void main(String[] args) {
        task1 task = new task1();
        System.out.println("[1, 2, 2, 1]: " + Arrays.toString(task.solve(new int[] {2, 1, 3, 2})));
        System.out.println("[4, 4, 4, 4]: " + Arrays.toString(task.solve(new int[] {5, 1, 3, 5})));
        System.out.println("[2, 2, 2, 2]: " + Arrays.toString(task.solve(new int[] {4, 6, 3, 5})));
        System.out.println("[3, 3, 3, 1]: " + Arrays.toString(task.solve(new int[] {4, 6, 2, 5})));
        System.out.println("[]: " + Arrays.toString(task.solve(new int[] {})));
        System.out.println("[1]: " + Arrays.toString(task.solve(new int[] {5})));
    }

    public int[] solve(int[] array) {
        int[] result = new int[array.length];
        int sum = 1;

        for (int i = 0, j = 1; i < array.length;) {
            while (j < array.length) {
                if ( (array[j-1]%2 == 0) == (array[j]%2 == 0) ) {
                    j++;
                    sum++;
                } else {
                    break;
                }
            }

            for (; i < j; i++) {
                result[i] = sum;
            }
            sum = 1;
            j++;
        }

        return result;
    }

//    public int[] solve(int[] array) {
//
//        int[] tmp = new int[array.length];
//        tmp[0] = 1;
//        for (int i = 1; i < array.length; i++) {
//            boolean chet_i = array[i] % 2 == 0;
//            boolean chet_i_1 = array[i-1] % 2 == 0;
//            if (chet_i == chet_i_1) {
//                tmp[i] = tmp[i-1] + 1;
//            } else {
//                tmp[i] = 1;
//            }
//        }
//
//        int[] result = new int[array.length];
//        int index = array.length - 1;
//        for (int i = array.length - 1; i >= 0; i--) {
//            result[i] = tmp[index];
//            if (tmp[i] == 1) {
//                index = i - 1;
//            }
//        }
//
//        return result;
//    }
}
