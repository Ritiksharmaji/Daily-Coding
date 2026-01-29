package Intermediate_2.Day_11_LabOn_2D_Matrices.AssignmentCoding;

import java.util.Arrays;

public class Assignment_3 {
    public int[] solve(int[][] A) {
        int[] result = new int[A.length];
        for(int i = 0; i< A.length; i++){
            int sum = 0;
            for(int j = 0; j <  A[i].length; j++){
                sum += A[i][j];
            }
            result[i] = sum;
        }
        return result;
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Assignment_3 object = new Assignment_3();
        int[] ans = object.solve(matrix);
        System.out.println("Array is :" + Arrays.toString(ans));
    }
}
