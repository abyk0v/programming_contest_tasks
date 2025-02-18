package top_hundred_interview_questions.eazy.strings;

import java.util.Arrays;

public class ReverseInteger {

    public static void main(String[] args) {
        int x = 123;
        int result = solve2(x);
        System.out.printf("expected: 321, result: %d\n", result);

        int x1 = -123;
        int result1 = solve2(x1);
        System.out.printf("expected: -321, result: %d\n", result1);

        int x2 = 120;
        int result2 = solve2(x2);
        System.out.printf("expected: 21, result: %d\n", result2);

        int x3 = 2047483648;
        int result3 = solve2(x3);
        System.out.printf("expected: 0, result: %d\n", result3);

    }

    /** O(n), где n - кол-во символов в числе */
    public static int solve(int x) {
        StringBuilder builder = new StringBuilder();
        if (x < 0) {
            builder.append('-');
        }
        for (int i = x; i != 0 ; i /= 10) {
            int n = i % 10;
            builder.append(Math.abs(n));
        }

        try {
            return Integer.parseInt( builder.toString() );
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    public static int solve2(int x) {
        try {
            int answer = 0;
            for (int i = x; i != 0; i /= 10) {
                int n = i % 10;

                answer = Math.addExact(Math.multiplyExact(answer, 10), n);
            }

//            if (x < 0) {
//                return -1 * answer;
//            }
            return answer;
        } catch (Exception ex) {
            return 0;
        }
    }
}
