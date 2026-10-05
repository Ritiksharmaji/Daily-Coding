package Intermediate_1.Day_6_Arrays_Prefix_Sum_and_Carry_Forward.ClassVideo;
/*

## ----- Problem-2: Given N array elements  and Q queries, for each query calculate sum of all even indexed elements from left to Right(Inclusive).

 */
public class Problem_2 {

    // ==========================================================
    // Method-1 : Brute Force
    // Time  : O(Q × N)
    // Space : O(1)
    // ==========================================================
    public static void rangeSumByBF(int[] array, int[][] queries) {

        System.out.println("========== Brute Force ==========");

        for (int q = 0; q < queries.length; q++) {

            int left = queries[q][0];
            int right = queries[q][1];

            int sum = 0;

            for (int i = left; i <= right; i++) {
                if(i % 2 == 0) {
                    sum += array[i];
                }
            }

            System.out.println("Query (" + left + "," + right + ") = " + sum);
        }
    }

    // ==========================================================
    // Method-2 : Better Approach
    // Build Prefix Array separately
    // Time  : O(N + Q)
    // Space : O(N)
    // ==========================================================
    public static void rangeSumByBetter(int[] array, int[][] queries) {

        System.out.println("\n========== Better Approach ==========");

        // Step-1 : Build Prefix Array
        int[] prefix = new int[array.length];

        prefix[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            if(i%2 == 0) {
                prefix[i] = prefix[i - 1] + array[i];
            }else{
                prefix[i] = prefix[i-1];
            }
        }

        // Print Prefix Array
        System.out.print("Prefix Array : ");
        for (int x : prefix) {
            System.out.print(x + " ");
        }
        System.out.println();

        // Step-2 : Answer Queries
        for(int q = 0; q < queries.length; q++) {

            int left = queries[q][0];
            int right = queries[q][1];
            int sum;

            if (left == 0) {
                sum = prefix[right];
            } else {
                sum = prefix[right] - prefix[left - 1];
            }

            System.out.println("Query (" + left + "," + right + ") = " + sum);
        }
    }

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

            if(i%2==0){
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

    // ==========================================================
    // Main Method
    // ==========================================================
    public static void main(String[] args) {

        int[] array = {-3, 6, 2, 4, 5, 2, 8, -9, 3, 1};

        int[][] queries = {
                {4, 8},
                {3, 7},
                {1, 3}
        };

        System.out.println("Original Array");
        printArray(array);

        // Method-1
        rangeSumByBF(array, queries);

        // Method-2
       rangeSumByBetter(array, queries);

        // Method-3
       rangeSumByOptimize(array, queries);
    }
}