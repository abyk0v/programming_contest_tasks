package top_hundred_interview_questions.eazy.array;

public class RotateImage {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        solve(matrix);
        System.out.println("Hello, matrix!");

        matrix = new int[][] {
                {5,1,9,11},
                {2,4,8,10},
                {13,3,6,7},
                {15,14,12,16}
        };
        solve(matrix);
        System.out.println("Hello, matrix_2!");
    }

    /** O(n/2) * O(n) => ~O(n^2) */
    private static void solve(int[][] matrix) {
        int position = 0;
        int length = matrix.length;
        for (int i = 0; i < matrix.length / 2; i++) {
            rotatePerimeter(matrix, position, position, length - 1);
            position += 1;
            length -= 2;
        }
    }

    private static void rotatePerimeter(int[][] matrix, int row, int column, int length) {
        for (int j = 0; j < length; j++) {
            int tmp = matrix[row + j][column + length];
            matrix[row + j][column + length] = matrix[row][column + j];

            int tmp2 = matrix[row + length][column + length - j];
            matrix[row + length][column + length - j] = tmp;

            tmp = matrix[row + length - j][column];
            matrix[row + length - j][column] = tmp2;

            matrix[row][column + j] = tmp;
        }
    }
}
