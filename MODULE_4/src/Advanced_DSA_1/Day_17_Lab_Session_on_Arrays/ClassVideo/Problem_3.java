package Advanced_DSA_1.Day_17_Lab_Session_on_Arrays.ClassVideo;

import java.util.*;

public class Problem_3 {

    public static ArrayList<Integer> spiral(int[][] A) {

        int n = A.length;
        int i = 0, j = 0;

        ArrayList<Integer> ans = new ArrayList<>();

        while (n > 1) {

            // top row
            for (int t = 1; t < n; t++) {
                ans.add(A[i][j]);
                j++;
            }

            // right column
            for (int t = 1; t < n; t++) {
                ans.add(A[i][j]);
                i++;
            }

            // bottom row
            for (int t = 1; t < n; t++) {
                ans.add(A[i][j]);
                j--;
            }

            // left column
            for (int t = 1; t < n; t++) {
                ans.add(A[i][j]);
                i--;
            }

            n -= 2;
            i++;
            j++;
        }

        if (n == 1) {
            ans.add(A[i][j]);
        }

        return ans;
    }

    public static void main(String[] args) {

        int[][] A = {
                {1 ,2 ,3 ,4},
                {5 ,6 ,7 ,8},
                {9 ,10,11,12},
                {13,14,15,16}
        };

        ArrayList<Integer> result = spiral(A);

        System.out.println(result);
    }
}