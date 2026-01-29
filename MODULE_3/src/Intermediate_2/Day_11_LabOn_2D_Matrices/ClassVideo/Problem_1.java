package Intermediate_2.Day_11_LabOn_2D_Matrices.ClassVideo;

/* Q-1: given a matrix a[m][n] print row wise sum */
/* by BF */
//public class Problem_1 {
//
//    public static void main(String[] args){
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//                {10, 11, 12}};
//        for(int i = 0; i< 4; i++){
//            int sum = 0;
//            for(int j = 0; j < 3; j++){
//                sum += matrix[i][j];
//            }
//            System.out.println("sum of row:"+ i +" is :"+ sum);
//
//        }
//    }
//}
// optimize approach
public class Problem_1 {

    public static void main(String[] args){
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}};
        for(int i = 0; i< 4; i++){
            int sum = 0;
            for(int j = 0; j < 3; j++){
                sum += matrix[i][j];
            }
            System.out.println("sum of row:"+ i +" is :"+ sum);

        }
    }
}