package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.strings;

public class LongestCommonPrefix {

    public static void main(String[] args) {
//        String[] strings1 = { "flower", "flow", "flight" };
//        System.out.printf("Expected: 'fl', actual: %s\n", solve(strings1));

        String[] strings2 = { "flower" };
        System.out.printf("Expected: 'flower', actual: %s\n", solve(strings2));
    }

    /**
     * memory: O(1), cpu: O(n^2)
     */
    private static String solve(String [] strings) {
        int lengthCommonPrefix = 0;
        for (int i = 0; i < strings[0].length(); i++) {
            char currentCharacter = strings[0].charAt(i);
            for (int j = 1; j < strings.length; j++) {
                if (strings[j].length() <= i || currentCharacter != strings[j].charAt(i)) {
                    return strings[0].substring(0, lengthCommonPrefix);
                }
            }
            lengthCommonPrefix++;
        }
        return strings[0].substring(0, lengthCommonPrefix);
    }
}
