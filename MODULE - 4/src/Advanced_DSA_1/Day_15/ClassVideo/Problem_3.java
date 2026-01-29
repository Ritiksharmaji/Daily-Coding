package Advanced_DSA_1.Day_15.ClassVideo;

import java.util.Arrays;

// Q-4: sme logic with extra x (l, r, x) → add x to all elements from index l to r (inclusive)
public class Problem_3 {
    // optimize apporach
    public static void main(String[] args) {

        int[] A = {0, 0, 0, 0, 0};

        int[][] queries = {
                {1, 3},
                {0, 2},
                {4, 1}
        };

        int n = A.length;
        int[] diff = new int[n];

        // Step 1 & 2: Apply queries to diff array
        for (int q = 0; q < queries.length; q++) {
            int i = queries[q][0];
            int x = queries[q][1];

            diff[i] += x;
        }

        // Step 3: Build final array using prefix sum
        A[0] = diff[0];
        for (int i = 1; i < n; i++) {
            A[i] = A[i - 1] + diff[i];
        }


        System.out.println(Arrays.toString(A));
    }
}
