package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.strings;

public class ValidPalindrome {

    public static void main(String[] args) {
        String str0 = "0P";
        System.out.printf("expected: false, return: %b\n", solve(str0));

        String str = "A man, a plan, a canal: Panama";
        System.out.printf("expected: true, return: %b\n", solve(str));

        String str2 = "race a car";
        System.out.printf("expected: false, return: %b\n", solve(str2));

        String str3 = " ";
        System.out.printf("expected: true, return: %b\n", solve(str3));

        String str4 = "a";
        System.out.printf("expected: true, return: %b\n", solve(str4));

    }

    // O(2n)
    private static boolean solve(String str) {
        // 1
        StringBuilder stringBuilder = new StringBuilder();
        for(char ch: str.toCharArray()) {
            if (Character.isAlphabetic(ch) || Character.isDigit(ch)) {
                stringBuilder.append(Character.toLowerCase(ch));
            }
        }

        String newStr = stringBuilder.toString();

//        if (newStr.length() == 0) {
//            return true;
//        }
//
//        if (newStr.length() == 1) {
//            return false;
//        }

        for (int i = 0, j = newStr.length()-1; i < j; i++, j--) {
            if (newStr.charAt(i) != newStr.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
