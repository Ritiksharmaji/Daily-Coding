package Intermediate_1.Day_7_Lab_Session_on_Prefix_Sum_and_Carry_Forward.ClassVideo;

/*
----------------------------------------------------------
Problem-1 : Print All Possible Subarrays
----------------------------------------------------------

Example

Array = {4,13,8}

Output

[4]
[4 13]
[4 13 8]
[13]
[13 8]
[8]

----------------------------------------------------------
*/

public class Problem_1 {

    // ====================================================
    // Method-1 : Standard / Brute Force
    // Time : O(N³)
    // Space : O(1)
    // ====================================================
    public static void printAllPossibleSubArrayByBFApproach(int[] ary){

        System.out.println("========== Brute Force ==========\n");

        for(int start = 0; start < ary.length; start++){

            for(int end = start; end < ary.length; end++){

                System.out.print("[ ");

                for(int k = start; k <= end; k++){

                    System.out.print(ary[k] + " ");

                }

                System.out.println("]");
            }
        }
    }

    // ====================================================
    // Method-2 : Optimized
    // Not Possible
    // Printing every subarray itself requires O(N³)
    // ====================================================
    public static void printAllPossibleSubArrayByOptimizeApproach(int[] ary){

        System.out.println("\n========== Optimized ==========");

        System.out.println("No optimized algorithm exists.");

        System.out.println("Reason:");

        System.out.println("To print every subarray,");
        System.out.println("we must print every element inside it.");

        System.out.println("Hence minimum complexity is O(N³).");
    }

    public static void main(String[] args){

        int[] array = {4,13,8};

        printAllPossibleSubArrayByBFApproach(array);

        printAllPossibleSubArrayByOptimizeApproach(array);
    }
}