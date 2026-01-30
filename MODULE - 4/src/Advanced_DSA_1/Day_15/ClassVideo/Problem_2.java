package Advanced_DSA_1.Day_15.ClassVideo;

import java.util.Arrays;

// Q-1: Given an integer array A of size N, return the subarray which has the maximum sum
public class Problem_2 {
    public static void main(String[] args){
//        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] A = {0, 0, 0, 0, 0};

        int currentSum = A[0];
        int maxSum = A[0];

        int start = 0;      // temp start
        int end = 0;        // final end
        int tempStart = 0;  // candidate start

        for (int i = 1; i < A.length; i++) {

            // Decide to start new subarray
            if (A[i] > currentSum + A[i]) {
                currentSum = A[i];
                tempStart = i;
            } else {
                currentSum += A[i];
            }

            // Update best result
            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        // Extract subarray
        int[] result = Arrays.copyOfRange(A, start, end + 1);

        System.out.println("Maximum Sum = " + maxSum);
        System.out.println("Subarray = " + Arrays.toString(result));
    }
}
