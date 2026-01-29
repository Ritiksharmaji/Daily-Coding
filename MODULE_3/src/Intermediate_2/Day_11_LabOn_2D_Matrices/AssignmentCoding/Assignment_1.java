package Intermediate_2.Day_11_LabOn_2D_Matrices.AssignmentCoding;

import java.util.Arrays;

public class Assignment_1 {

    public int[] solve(int[][] A) {
        int n = A.length;
        int col = n-1;
        int[][] ans = new int[n][n];
        for(int i = 0; i<n; i++){
            System.out.print(A[i][col-1]);
        }

        return new int[n];
    }
    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        Assignment_1 object = new Assignment_1();
        object.solve(matrix);
//        int[] ans = object.solve(matrix);
//        System.out.println("Array is :"+ Arrays.toString(ans));
        }
}
