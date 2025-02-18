package top_hundred_interview_questions.eazy.array;

import java.util.Arrays;

public class ValidSudoku {

    public static void main(String[] args) {
        char[][] board = {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','9','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.printf("1. expected: true, result: %s\n", solve(board));

        char[][] board2 = {
                {'8','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };

        System.out.printf("2. expected: false, result: %s\n", solve(board2));
    }

    /** O(3^2 * N^2) + O(N^2) + O(N^2) => O(3*N^2) */
    private static boolean solve(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!solve3x3(board, i*3, j*3)) {
                    return false;
                }
            }
        }

        for (char[] chars : board) {
            if (!solveHorizontalLine(chars)) {
                return false;
            }
        }

        return solveVerticalLine(board);
    }

    private static boolean solve3x3(char[][] board, int a, int b) {
        byte[] numbers = new byte[10];
        for (int i = a; i < a+3; i++) {
            for (int j = b; j < b+3; j++) {
                if (board[i][j] == '.') continue;
                if (numbers[Character.getNumericValue(board[i][j])] != 0) {
                    return false;
                }
                numbers[Character.getNumericValue(board[i][j])] = 1;
            }
        }
        return true;
    }

    private static boolean solveHorizontalLine(char[] line) {
        byte[] numbers = new byte[10];
        for (char c : line) {
            if (c == '.') continue;
            if (numbers[Character.getNumericValue(c)] != 0) {
                return false;
            }
            numbers[Character.getNumericValue(c)] = 1;
        }
        return true;
    }

    private static boolean solveVerticalLine(char[][] board) {
        byte[] numbers = new byte[10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == '.') continue;
                if (numbers[Character.getNumericValue(board[j][i])] != 0) {
                    return false;
                }
                numbers[Character.getNumericValue(board[j][i])] = 1;
            }
            Arrays.fill(numbers, (byte) 0);
        }
        return true;
    }
}
