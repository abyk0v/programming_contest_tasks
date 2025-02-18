package top_hundred_interview_questions.eazy.array;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits0 = {1,2,3};
        int[] result0 = solve(digits0);
        System.out.printf("1. expected: [1,2,4], result: %s\n", Arrays.toString(result0));

        int[] digits1 = {4,3,2,1};
        int[] result1 = solve(digits1);
        System.out.printf("2. expected: [4,3,2,2], result: %s\n", Arrays.toString(result1));

        int[] digits2 = {9};
        int[] result2 = solve(digits2);
        System.out.printf("3. expected: [1,0], result: %s\n", Arrays.toString(result2));

        int[] digits3 = {9,9,9};
        int[] result3 = solve(digits3);
        System.out.printf("4. expected: [1,0,0,0], result: %s\n", Arrays.toString(result3));

        int[] digits4 = {8,9,9,9};
        int[] result4 = solve(digits4);
        System.out.printf("4. expected: [9,0,0,0], result: %s\n", Arrays.toString(result4));
    }

    private static int[] solve(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            digits[i] = 0;
        }
        int[] answer = new int[digits.length + 1];
        answer[0] = 1;
        return answer;
    }


//    private static int[] solve(int[] digits) {
//        int[] result = new int[digits.length + 1];
//        int perenos = 1;
//        for (int i = digits.length-1; i >= 0; i--) {
//            result[i+1] = (digits[i] + perenos) % 10;
//            perenos = (digits[i] + perenos) / 10;
//        }
//        if (perenos > 0) {
//            result[0] = perenos;
//        } else {
//            result = Arrays.copyOfRange(result, 1, result.length);
//        }
//
//        return result;
//    }

//    private static int[] solve(int[] digits) {
//        int[] result = new int[digits.length];
//
//        int perenos = 0;
//        for (int i = 0; i < digits.length; i++) {
//            result[i] = (digits[i] + perenos) % 10;
//            perenos = (digits[i] + perenos) / 10;
//        }
//        if (perenos > 0) {
//            result = Arrays.copyOf(result, digits.length + 1);
//            result[result.length - 1] = perenos;
//        }
//
//        return result;
//    }
}
