package Intermediate_1.Day_7_Lab_Session_on_Prefix_Sum_and_Carry_Forward.ClassVideo;
/*
## --------- Problem-3: Special Index(related to PF-Sum ( Given an array of size N. Find the number of special indices. A special index is an index such that after removing that element Sum of Even Indexed Elements = Sum of Odd Indexed Elements))------
 */
public class Problem_3 {

    public static int countSpecialIndex(int[] A){

        int n = A.length;

        int[] evenPrefix = new int[n];
        int[] oddPrefix = new int[n];

        evenPrefix[0] = A[0];
        oddPrefix[0] = 0;

        for(int i = 1; i < n; i++){

            evenPrefix[i] = evenPrefix[i - 1];
            oddPrefix[i] = oddPrefix[i - 1];

            if(i % 2 == 0)
                evenPrefix[i] += A[i];
            else
                oddPrefix[i] += A[i];
        }

        int totalEven = evenPrefix[n - 1];
        int totalOdd = oddPrefix[n - 1];

        int answer = 0;

        for(int i = 0; i < n; i++){

            int leftEven = (i == 0) ? 0 : evenPrefix[i - 1];
            int leftOdd = (i == 0) ? 0 : oddPrefix[i - 1];

            int rightEven = totalEven - evenPrefix[i];
            int rightOdd = totalOdd - oddPrefix[i];

            int newEven = leftEven + rightOdd;
            int newOdd = leftOdd + rightEven;

            if(newEven == newOdd){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args){
    int[] array = {4,3,2,7,6,-2};
    int totalSpecialIndexByOptimize = countSpecialIndex(array);
    System.out.println("total number of special index are :"+totalSpecialIndexByOptimize);
    }

}
