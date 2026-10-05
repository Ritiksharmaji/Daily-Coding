package Advanced_DSA_1.Day_17_Lab_Session_on_Arrays.ClassVideo;

import java.util.Arrays;

public class Problem_4 {

    public static int[] nextPermutation(int[] A) {
        int n = A.length;
        int i = n - 2;

        // Step 1: find breakpoint
        while (i >= 0 && A[i] >= A[i + 1]) {
            i--;
        }

        // Step 2: find next greater & swap
        if (i >= 0) {
            int j = n - 1;
            while (A[j] <= A[i]) {
                j--;
            }
            swap(A, i, j);
        }

        // Step 3: reverse suffix
        reverse(A, i + 1, n - 1);

        return A;
    }

    private static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private static void reverse(int[] A, int l, int r) {
        while (l < r) {
            swap(A, l, r);
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        int[] A = {1, 4, 7, 6, 5};
        int[] ans = nextPermutation(A);
        System.out.println("Next permutation is: " + Arrays.toString(ans));
    }
}
