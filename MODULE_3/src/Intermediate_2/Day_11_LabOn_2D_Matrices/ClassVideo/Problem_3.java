package Intermediate_2.Day_11_LabOn_2D_Matrices.ClassVideo;

// Q-3: Print the anti-diagonal of tringle starting from a given index (i, j)
//public class Problem_3 {
//    public static void main(String[] args){
//        int[][] matrix = {
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//                {10, 11, 12}};
//        int i = 1;
//        int j = 1;
//        int row = i, col = j;
//        int[][]  tep= new int[][]{new int[matrix.length]};
//        while (row < matrix.length && col >= 0) {
//            System.out.print(matrix[row][col] + " ");
//            row++;
//            col--;
//        }
//    }
//}

public class Problem_3 {
    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
                {10, 11, 12}
        };

        int i = 1;
        int j = 1;

        int row = i, col = j;

        System.out.println("Anti-diagonal starting from (" + i + ", " + j + "):");

        while (row < matrix.length && col >= 0 && col < matrix[0].length) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col--;
        }
    }
}
