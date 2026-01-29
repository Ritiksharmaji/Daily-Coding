package Intermediate_2.Day_11_LabOn_2D_Matrices.ClassVideo;
// Q-2: given a 2d square matrix mat[n][n], print diagonals
// ans- in a 2D matrix there is two types of diagonals 1) principal diagonals which is from top left to bottom right.
// 2) anti-diagonals which is top right to bottom left
public class Problem_2 {

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};
        // to print principal diagonals
        System.out.println("printing principal diagonal");
        for(int i = 0; i<3; i++){
            System.out.print(matrix[i][i] + " ");
        }
        System.out.println();
        System.out.println("printing anti-diagonal");
        int count = 3-1;
        for(int i = 0; i<3; i++){
            System.out.print(matrix[i][count - i] + " ");
        }
    }
}
