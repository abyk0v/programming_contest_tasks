package ru.bykov.leetcode.season_one.medium;

public class task5_Longest_Palindromic_Substring {
    public static void main(String[] args) {
        var task = new task5_Longest_Palindromic_Substring();
        System.out.println( "bb: " + task.longestPalindrome("bb") );
        System.out.println( "bab: " + task.longestPalindrome("babad") );
        System.out.println( "bb: " + task.longestPalindrome("cbbd") );
    }

    public String longestPalindrome(String s) {
        String max = s.substring(0, 1);
        for (int i = 0; i < s.length() - max.length(); i++) {
            for (int j = i+1; j < s.length(); j++) {
                String substring = s.substring(i, j+1);
                if (isPalindromic(substring) && substring.length() > max.length()) {
                    max = substring;
                }
            }
        }
        return max;
    }

    private boolean isPalindromic(String str) {
        for (int i = 0; i < str.length()/2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}
