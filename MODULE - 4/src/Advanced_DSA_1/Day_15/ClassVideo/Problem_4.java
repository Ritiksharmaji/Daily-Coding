package Advanced_DSA_1.Day_15.ClassVideo;

import java.util.Arrays;

// Q-3: (l, r, x) → add x to all elements from index l to r (inclusive) --
public class Problem_4 {
    // optimize approach
    public static void main(String[] args) {

        int[] A = {0,0,0,0,0};
        int[][] queries = {
                {1,3,2},
                {0,2,1},
                {4,4,3}
        };

        int[] diff = new int[A.length];

// Step 1: process queries
        for (int[] q : queries) {
            int l = q[0];
            int r = q[1];
            int x = q[2];

            diff[l] += x;
            if (r + 1 < A.length) {
                diff[r + 1] -= x;
            }
        }

// Step 2: prefix sum
        A[0] = diff[0];
        for (int i = 1; i < A.length; i++) {
            A[i] = A[i - 1] + diff[i];
        }


        System.out.println(Arrays.toString(A));
    }
}
