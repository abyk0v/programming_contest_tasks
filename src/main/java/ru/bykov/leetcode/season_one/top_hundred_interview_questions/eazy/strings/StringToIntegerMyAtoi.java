package ru.bykov.leetcode.season_one.top_hundred_interview_questions.eazy.strings;

public class StringToIntegerMyAtoi {

    public static void main(String[] args) {
//        String s = "42";
//        System.out.printf("expected: 42, result: %d\n", solve(s));
//
//        String s2 = "-42";
//        System.out.printf("expected: -42, result: %d\n", solve(s2));
//
//        String s3 = "4193 with words";
//        System.out.printf("expected: 4193, result: %d\n", solve(s3));
//
//        String s4 = "-+12";
//        System.out.printf("expected: 0, result: %d\n", solve(s4));
//
//        String s5 = "-";
//        System.out.printf("expected: 0, result: %d\n", solve(s5));
//
//        String s6 = "-2147483647";
//        System.out.printf("expected: -2147483647, result: %d\n", solve(s6));
//
//        String s7 = "  0000000000012345678";
//        System.out.printf("expected: 12345678, result: %d\n", solve(s7));
//
//        String s7 = "words and 987";
//        System.out.printf("expected: 0, result: %d\n", solve(s7));

        String s8 = "00000-42a1234";
        System.out.printf("expected: 0, result: %d\n", solve(s8));
    }

    public static int solve(String s) {
        boolean isNegative = false;
        int lastIndex = 0;
        for (int i = 0; i < s.length()-1 && s.charAt(lastIndex) == ' '; i++, lastIndex++) {
        }

        if (lastIndex == s.length()-1) return 0;

        if (s.charAt(lastIndex) == '-') {
            isNegative = true;
            lastIndex += 1;

            if (lastIndex == s.length() || !Character.isDigit(s.charAt(lastIndex))) return 0;
        }
        if (s.charAt(lastIndex) == '+' && !isNegative) lastIndex += 1;

        StringBuilder stringBuilder = new StringBuilder();
        while (lastIndex < s.length() && Character.isDigit(s.charAt(lastIndex))) {
            stringBuilder.append(s.charAt(lastIndex));
            lastIndex += 1;
        }

        String digit = stringBuilder.toString();

        int resultNumber = parseDigit(digit, isNegative);
        return isNegative ? -resultNumber : resultNumber;
    }

    private static int parseDigit(String digit, boolean isNegative) {
        if (digit.isEmpty()) return 0;
        // удалить лидирующие нули
        digit = deleteLiderZero(digit);

        if (digit.length() > 10
                || (digit.length() == 10 && Character.digit(digit.charAt(0), 10) > 2)) {
            return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        int result = 0;
        int rate = 1;
        for (int i = digit.length() - 1; i >= 0; i--) {
            int number = Character.digit(digit.charAt(i), 10) * rate;

            // проверка на переполнения
            if (!isNegative) {
                if (Integer.MAX_VALUE - number <= result) {
                    return Integer.MAX_VALUE;
                }
            } else if (Integer.MIN_VALUE + number >= -result) {
                return Integer.MIN_VALUE;
            }
//            if (Integer.MAX_VALUE - number <= result) {
//                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//            }

            rate *= 10;
            result += number;
        }
        return result;
    }

    private static String deleteLiderZero(String digit) {
        int firstNonZeroDigit = 0;
        while (firstNonZeroDigit < digit.length()-1 && digit.charAt(firstNonZeroDigit) == '0') {
            firstNonZeroDigit++;
        }
        return digit.substring(firstNonZeroDigit);
    }

}
