package Intermediate_2.Day_11_LabOn_2D_Matrices.ClassVideo;
// Q : print all the anti-dialogs of triangle array
public class Problem_2_2 {

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        System.out.println("Printing all anti-diagonals:");

        // row + col varies from 0 to rows + cols - 2
        for (int sum = 0; sum <= rows + cols - 2; sum++) {

            for (int row = 0; row < rows; row++) {
                int col = sum - row;

                if (col >= 0 && col < cols) {
                    System.out.print(matrix[row][col] + " ");
                }
            }
            System.out.println();
        }
    }
}
