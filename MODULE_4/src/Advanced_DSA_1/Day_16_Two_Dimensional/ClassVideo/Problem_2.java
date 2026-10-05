package Advanced_DSA_1.Day_16_Two_Dimensional.ClassVideo;
// Q-2: given a matrix of size m*n calculate and print the final sum of the sum of all its submatrixes
public class Problem_2 {
    public static int FindTotalSumOfAllSubArraySum(int[][] A){
        int m = A.length;
        int n = A[0].length;
        int totalSum = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = (i + 1) * (j + 1) * (m - i) * (n - j);
                totalSum += A[i][j] * count;
            }
        }
        return totalSum;
    }

    public static void main(String[] arges){

        int[][] matrix = {
                {-5, -2, 1, 13},
                {-4, 0, 3, 14},
                {-3, 2, 5, 18},
                {2, 6, 10, 20}
        };
        int [][] matrix2 = {
                {4,9,6},
                {5,-1,2}
        };
        System.out.println("total sum of all possible sub-array sum is :" + FindTotalSumOfAllSubArraySum(matrix));
        System.out.println("total sum of all possible sub-array sum is :" + FindTotalSumOfAllSubArraySum(matrix2));
    }
}
