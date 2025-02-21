package ru.bykov.leetcode.season_one.tbank_mock_interview;

import java.util.Deque;
import java.util.LinkedList;

public class BackspacesInString {

    public static void main(String[] args) {
        BackspacesInString test = new BackspacesInString();

        System.out.println("expected: ac, actual: " + test.solve("abc#d##c"));
        System.out.println("expected: '', actual: " + test.solve("abc##d#####"));
        System.out.println("expected: '', actual: " + test.solve("ab#c#d#d#d#d#d#"));
        System.out.println("expected: '', actual: " + test.solve("#####"));
        System.out.println("expected: '', actual: " + test.solve("''"));

    }

    /**
     * cpu: O(N), memory: O(N)
     */
    public String solve(String str) {
        Deque<Character> chars = new LinkedList<>();
        for(int i = 0; i< str.length(); i++) {
            if (str.charAt(i) == '#' && !chars.isEmpty()) {
                chars.removeLast();
            }
            if (str.charAt(i) != '#') {
                chars.add(str.charAt(i));
            }
        }

        StringBuilder strBuilder = new StringBuilder();
        chars.forEach(strBuilder::append);
        return strBuilder.toString();
    }
}
