package top_hundred_interview_questions.eazy.strings;

public class ImplementStrStr {

    public static void main(String[] args) {
        String needle = "sadbutsad";
        String haystack = "sad";
        System.out.printf("expected: 0, actual: %d\n", solve(needle, haystack));

        String needle2 = "leetcode";
        String haystack2 = "leeto";
        System.out.printf("2. expected: 0, actual: %d\n", solve(needle2, haystack2));
    }

    private static int solve2(String needle, String haystack) {
        return needle.indexOf(haystack);
    }

    private static int solve(String needle, String haystack) {
        return needle.indexOf(haystack);
    }
}
