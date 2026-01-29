package Intermediate_2.Day_11_LabOn_2D_Matrices.ClassVideo;
// Q-6: Given a 2D array, if any element is 0, then make its entire row and entire column 0.
//This is the “Set Matrix Zeroes” problem.
public class Problem_6 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 0},
                {4, 5, 6},
                {7, 0, 9},
                {10, 11, 12}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean[] row = new boolean[rows];
        boolean[] col = new boolean[cols];

        // Step 1: Mark rows and columns containing 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        // Step 2: Set matrix cells to 0
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (row[i] || col[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Print result
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
