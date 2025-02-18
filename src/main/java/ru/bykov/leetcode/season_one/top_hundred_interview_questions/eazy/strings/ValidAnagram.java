package top_hundred_interview_questions.eazy.strings;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean result = solve(s, t);
        System.out.printf("1. expected: true, result: %b\n", result);

        String s2 = "rat", t2 = "car";
        boolean result2 = solve(s2, t2);
        System.out.printf("1. expected: true, result: %b\n", result2);

    }

    /** O(n) + O(n) */
    private static boolean solve(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> chars = new HashMap<>();
        for (char ch: s.toCharArray()) {
            chars.compute(ch, (key, count) -> count == null ? 1 : count + 1);
        }

        for (char ch: t.toCharArray()) {
            Integer count = chars.get(ch);

            if (count == null || count == 0) return false;

            chars.put(ch, count - 1);
        }

        return true;
    }
}
