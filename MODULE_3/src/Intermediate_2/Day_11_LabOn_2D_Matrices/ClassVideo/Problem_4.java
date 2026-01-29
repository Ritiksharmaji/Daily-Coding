package Intermediate_2.Day_11_LabOn_2D_Matrices.ClassVideo;

// Q-4: Print the anti-diagonal of tringle starting from 0th row.
public class Problem_4 {

    // function to print the anti-dialog with given range(i,j, matrix)
    public static void printAntiDailogs(int row, int col, int[][] matrix){
        while (row < matrix.length && col >= 0 ) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col--;
        }
        System.out.println();
    }
    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        int row = 0;
       for(int col =0; col < matrix[0].length; col++){
           printAntiDailogs(row, col, matrix);
       }
    }
}
