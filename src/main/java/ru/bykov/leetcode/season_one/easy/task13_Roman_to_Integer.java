package ru.bykov.leetcode.season_one.easy;

import java.util.HashMap;
import java.util.Map;

public class task13_Roman_to_Integer {

    public static void main(String[] args) {
        task13_Roman_to_Integer task = new task13_Roman_to_Integer();

        System.out.println("3 == " + task.romanToInt("III"));
        System.out.println("58 == " + task.romanToInt("LVIII"));
        System.out.println("1994 == " + task.romanToInt("MCMXCIV"));
    }

    // Version 2
    Map<Character, Integer> map = new HashMap<>();
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int result = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = s.length() - 1; i >= 0; i--) {
            int number = toInt(s.charAt(i));
            if (number < prev) {
                result -= number;
            } else {
                result += number;
            }
            prev = number;
        }

        return result;
    }

//    public int romanToInt(String s) {
//        char lastCh = ' ';
//
//        int result = 0;
//        for (char ch: s.toCharArray()) {
//            if (lastCh == ' ') {
//                lastCh = ch;
//                continue;
//            }
//
//            if (lastCh == 'I' && ch == 'V') {
//                result += 4;
//                lastCh = ' ';
//            } else if (lastCh == 'I' && ch == 'X') {
//                result += 9;
//                lastCh = ' ';
//            } else if (lastCh == 'X' && ch == 'L') {
//                result += 40;
//                lastCh = ' ';
//            } else if (lastCh == 'X' && ch == 'C') {
//                result += 90;
//                lastCh = ' ';
//            } else if (lastCh == 'C' && ch == 'D') {
//                result += 400;
//                lastCh = ' ';
//            } else if (lastCh == 'C' && ch == 'M') {
//                result += 900;
//                lastCh = ' ';
//            } else {
//                result += toInt(lastCh);
//                lastCh = ch;
//            }
//        }
//
//        if (lastCh != ' ') {
//            result += toInt(lastCh);
//        }
//
//        return result;
//    }

    public int toInt(char ch) {
        return switch (ch) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
