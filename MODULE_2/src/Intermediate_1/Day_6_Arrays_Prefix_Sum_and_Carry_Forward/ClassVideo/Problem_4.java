package src.Intermediate_1.Day_6_Arrays_Prefix_Sum_and_Carry_Forward.ClassVideo;

/*
-------------------------------------------------------------
Problem-4 : Count Total Number of Subarrays
-------------------------------------------------------------

A subarray is a continuous part of an array.

Example:
Array = {3,4,5}

Subarrays:
[3]
[3,4]
[3,4,5]
[4]
[4,5]
[5]

Total = 6
-------------------------------------------------------------
*/

public class Problem_4 {

    // ==========================================================
    // Method-1 : Brute Force
    // Time  : O(N²)
    // Space : O(1)
    // ==========================================================
    public static int countSubarraysByBF(int[] array) {

        int count = 0;

        for (int start = 0; start < array.length; start++) {

            for (int end = start; end < array.length; end++) {

                // Here one subarray is formed
                count++;
            }
        }

        return count;
    }

    // ==========================================================
    // Method-2 : Optimized (Mathematical Formula)
    // Time  : O(1)
    // Space : O(1)
    // Formula = N * (N + 1) / 2
    // ==========================================================
    public static int countSubarraysByOptimize(int[] array) {

        int n = array.length;

        return n * (n + 1) / 2;
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

        int[] array = {3, 4, 5, 6};

        System.out.println("Original Array");
        printArray(array);

        System.out.println();

        // -----------------------------
        // Method-1 : Brute Force
        // -----------------------------
        int bfAns = countSubarraysByBF(array);
        System.out.println("Brute Force Count = " + bfAns);

        // -----------------------------
        // Method-2 : Optimized
        // -----------------------------
        int optAns = countSubarraysByOptimize(array);
        System.out.println("Optimized Count = " + optAns);
    }
}