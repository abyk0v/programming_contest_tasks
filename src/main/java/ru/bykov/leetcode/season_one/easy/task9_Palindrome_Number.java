package ru.bykov.leetcode.season_one.easy;

public class task9_Palindrome_Number {

    public static void main(String[] args) {
        task9_Palindrome_Number task = new task9_Palindrome_Number();
        System.out.println( " 121: " + task.run(121) );
        System.out.println( "-121: " + task.run(-121) );
        System.out.println( "  10: " + task.run(10) );
        System.out.println( "  11: " + task.run(11) );
        System.out.println( "2147483647: " + task.run(2147483647) );
    }

    boolean run(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;

        int palindrom = 0;
        while (x > palindrom) {
            palindrom = palindrom * 10 + x % 10;
            x /= 10;
        }

        return x == palindrom || x == palindrom/10;
    }

    // Через String
    public boolean isPalindrome(int x) {
        String str = Integer.toString(x);

        int i = 0;
        int j = str.length() - 1;
        for (; i < j; i++, j--) {
            if (str.charAt(i) != str.charAt(j)) return false;
        }
        return true;
    }
}
