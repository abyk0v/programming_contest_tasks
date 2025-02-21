package ru.bykov.leetcode.eazy;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class BackspaceStringCompare {

    public static void main(String[] args) {

    }

    /**
     * time: O(N + M + min(N, M)) => O(3N) => O(N)
     * где N - s.length, M - t.length
     *
     * memory: O(N + M)
     */
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> chars1 = new LinkedList<>();
        for (int i = 0; i < s.length(); i++ ) {
            if (s.charAt(i) == '#' && !chars1.isEmpty()) {
                chars1.removeLast();
            }
            if (s.charAt(i) != '#') {
                chars1.add(s.charAt(i));
            }
        }

        Deque<Character> chars2 = new LinkedList<>();
        for (int i = 0; i < t.length(); i++ ) {
            if (t.charAt(i) == '#' && !chars2.isEmpty()) {
                chars2.removeLast();
            }
            if (t.charAt(i) != '#') {
                chars2.add(t.charAt(i));
            }
        }

        if (chars1.size() != chars2.size()) {
            return false;
        }
        Iterator<Character> iterator1 = chars1.iterator();
        Iterator<Character> iterator2 = chars2.iterator();
        while (iterator1.hasNext() && iterator2.hasNext()) {
            if (iterator1.next() != iterator2.next()) {
                return false;
            }
        }
        return true;
    }

    public boolean backspaceCompare2(String s, String t) {
        Deque<Character> chars1 = new LinkedList<>();
        for (char ch: s.toCharArray()) {
            if (ch == '#' && !chars1.isEmpty()) {
                chars1.removeLast();
            }
            if (ch != '#') {
                chars1.add(ch);
            }
        }

        Deque<Character> chars2 = new LinkedList<>();
        for (char ch: t.toCharArray()) {
            if (ch == '#' && !chars2.isEmpty()) {
                chars2.removeLast();
            }
            if (ch != '#') {
                chars2.add(ch);
            }
        }

        return String.valueOf(chars1).equals(String.valueOf(chars2));
    }
}
