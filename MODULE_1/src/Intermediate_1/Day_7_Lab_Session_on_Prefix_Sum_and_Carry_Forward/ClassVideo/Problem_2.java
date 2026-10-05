package Intermediate_1.Day_7_Lab_Session_on_Prefix_Sum_and_Carry_Forward.ClassVideo;
/*
Problem-2: Sum of odd indexed elements(related to PF-sum)-
 */
public class Problem_2 {
    // ==========================================================
    // Method-3 : Optimized
    // Prefix + Queries in one method
    // Time  : O(N + Q)
    // Space : O(N)
    // ==========================================================
    public static void rangeSumByOptimize(int[] array, int[][] queries) {

        System.out.println("\n========== Optimized ==========");

        int[] prefix = new int[array.length];

        prefix[0]=array[0];

        for(int i=1;i<array.length;i++){

            prefix[i]=prefix[i-1];

            if(i%2!=0){
                prefix[i]+=array[i];
            }

        }
        for (int q = 0; q < queries.length; q++) {

            int left = queries[q][0];
            int right = queries[q][1];

            int sum = (left == 0)
                    ? prefix[right]
                    : prefix[right] - prefix[left - 1];

            System.out.println("Query (" + left + "," + right + ") = " + sum);
        }
    }

    // ==========================================================
    // Print Array
    // ==========================================================
    public static void printArray(int[] array) {

        for (int x : array) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
public static void main(String[] args){
    int[] array = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};

    int[][] queries = {
            {4, 8},
            {3, 7},
            {1, 3}
    };
    // Method-3
    rangeSumByOptimize(array, queries);

}

}

