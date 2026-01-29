package Intermediate_2.Day_11_LabOn_2D_Matrices.ClassVideo;
// Given: a non-square matrix
//Task: Count right-to-left anti-diagonals
public class Problem_2_3 {

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int rows = matrix.length;
        int cols = matrix[0].length;

        int antiDiagonalCount = rows + cols - 1;

        System.out.println("Right-to-left anti-diagonals count: " + antiDiagonalCount);
    }
}
