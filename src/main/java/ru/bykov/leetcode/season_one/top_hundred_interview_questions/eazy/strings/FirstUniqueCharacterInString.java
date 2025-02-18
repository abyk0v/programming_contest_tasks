package top_hundred_interview_questions.eazy.strings;

public class FirstUniqueCharacterInString {

    public static void main(String[] args) {
        String str = "leetcode";
        int result = solve(str);
        System.out.printf("expected: 0, result: %d\n", result);

        String str2 = "loveleetcode";
        int result2 = solve(str2);
        System.out.printf("expected: 2, result: %d\n", result2);

        String str3 = "aabb";
        int result3 = solve(str3);
        System.out.printf("expected: -1, result: %d\n", result3);

    }

    /** O(2n) */
    private static int solve(String str) {
        int[] symbols = new int[124];

        for (int i = 0; i < str.length(); i++) {
            symbols[str.charAt(i)] += 1;
        }

        for (int i = 0; i < str.length(); i++) {
            if (symbols[str.charAt(i)] == 1) {
                return i;
            }
        }

        return -1;
    }
}
