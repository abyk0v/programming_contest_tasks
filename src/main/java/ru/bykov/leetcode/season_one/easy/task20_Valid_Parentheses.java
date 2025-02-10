package ru.bykov.leetcode.season_one.easy;

import java.util.Deque;
import java.util.LinkedList;

public class task20_Valid_Parentheses {

    public static void main(String[] args) {
        task20_Valid_Parentheses task = new task20_Valid_Parentheses();

        System.out.println("true == " + task.isValid("()"));
        System.out.println("true == " + task.isValid("()[]{}"));
        System.out.println("false == " + task.isValid("(]"));
        System.out.println("false == " + task.isValid("["));
        System.out.println("false == " + task.isValid("({)}"));
        System.out.println("false == " + task.isValid("({}{})"));
    }

    public boolean isValid(String s) {
        Deque<Character> stack = new LinkedList<>();

        for (char ch: s.toCharArray()) {
            switch (ch) {
                case '(', '{', '[' -> stack.add(ch);
                case ')' -> {
                    if (stack.isEmpty() || stack.removeLast() != '(')
                        return false;
                }
                case '}' -> {
                    if (stack.isEmpty() || stack.removeLast() != '{')
                        return false;
                }
                case ']' -> {
                    if (stack.isEmpty() || stack.removeLast() != '[')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
