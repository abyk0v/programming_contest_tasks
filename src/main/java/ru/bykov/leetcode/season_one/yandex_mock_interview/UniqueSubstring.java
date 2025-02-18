package yandex_mock_interview;

import java.util.HashSet;

public class UniqueSubstring {

    /**
     *
     *
     *
     */

    public static void main(String[] args) {
        String str = "abcabcbb";
        String answer = solve(str);
        System.out.printf("expected: abc, actual: %s\n", answer);
    }

    public static String solve(String str) {
        int maxLenght = 0, x = 0, y = 0;
        HashSet<Character> charSet = new HashSet<>();
        for (int left = 0; left < str.length(); left++) {
            int right = left;
            while (right < str.length() && !charSet.contains(str.charAt(right))) {
                charSet.add(str.charAt(right));
                right++;
            }

            if (right - left > maxLenght) {
                maxLenght = right - left;
                x = left;
                y = right;
            }
            charSet.clear();
        }

        return str.substring(x, y);
    }
}
