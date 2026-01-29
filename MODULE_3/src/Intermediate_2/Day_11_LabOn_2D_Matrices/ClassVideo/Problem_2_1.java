package Intermediate_2.Day_11_LabOn_2D_Matrices.ClassVideo;
// PrintAllDiagonals (Main dialogs)
public class Problem_2_1 {

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int n = matrix.length;

        // All diagonals from top-left to bottom-right
        for (int d = 0; d <= 2 * n - 2; d++) {
            for (int i = 0; i < n; i++) {
                int j = d - i;
                if (j >= 0 && j < n) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
