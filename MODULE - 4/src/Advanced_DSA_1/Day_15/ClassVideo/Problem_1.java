package Advanced_DSA_1.Day_15.ClassVideo;

// Q-1: Given an integer
// array A of size N, find the maximum subarray sum among all possible subarrays.
public class Problem_1 {
    public static void main(String[] args){
        int[] A = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int currentSum = A[0];
        int maxSum = A[0];

        for (int i = 1; i < A.length; i++) {

            // Decide: extend previous subarray OR start new
            currentSum = Math.max(A[i], currentSum + A[i]);

            // Update global maximum
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Maximum Subarray Sum = " + maxSum);
    }
}
