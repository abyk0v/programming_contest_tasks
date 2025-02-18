package top_hundred_interview_questions.eazy.strings;

import java.util.Arrays;

public class ReverseString {

    public static void main(String[] args) {
        char[] str = {'h','e','l','l','o'};
        solve(str);
        System.out.printf("expected: [o, l, l, e, h], result: %s", Arrays.toString(str));
    }

    /** O(n/2) */
    public static void solve(char[] str) {
        for (int i = 0; i < str.length / 2; i++) {
            char tmp = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = tmp;
        }
    }
}
