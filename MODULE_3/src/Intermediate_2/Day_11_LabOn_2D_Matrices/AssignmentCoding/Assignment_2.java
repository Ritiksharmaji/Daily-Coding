package Intermediate_2.Day_11_LabOn_2D_Matrices.AssignmentCoding;

import java.util.Arrays;

public class Assignment_2 {

    public int[] solve(int[][] A) {
        int rows = A.length;
        int cols = A[0].length;

        int[] result = new int[cols];

        for (int j = 0; j < cols; j++) {      // column loop
            int sum = 0;
            for (int i = 0; i < rows; i++) { // row loop
                sum += A[i][j];
            }
            result[j] = sum;
        }

        return result;
    }
    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Assignment_2 object = new Assignment_2();
        int[] ans = object.solve(matrix);
        System.out.println("Array is :"+ Arrays.toString(ans));
    }
}
