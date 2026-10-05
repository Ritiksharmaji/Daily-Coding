package Intermediate_1.Day_4_Intermediate_DSA_Introduction_to_Arrays.ClassVideo;

import java.util.Arrays;

public class Problem_3 {

    // Better Approach (Extra Array)
    public static int[] RotateArrayByBFApproach(int[] ary, int rotateCount){

        rotateCount = rotateCount % ary.length;

        int[] ans = new int[ary.length];

        int splitIndex = ary.length - rotateCount;

        int index = 0;

        // Copy last rotateCount elements
        for(int i = splitIndex; i < ary.length; i++){
            ans[index++] = ary[i];
        }

        // Copy remaining elements
        for(int i = 0; i < splitIndex; i++){
            ans[index++] = ary[i];
        }

        return ans;
    }

    // Optimal Approach (3 Reversals)
    public static int[] RotateArrayByOptimizeApproach(int[] ary,int rotateCount){

        rotateCount = rotateCount % ary.length;

        ReverArrayPartByOptimize(ary,0,ary.length-1);

        ReverArrayPartByOptimize(ary,0,rotateCount-1);

        ReverArrayPartByOptimize(ary,rotateCount,ary.length-1);

        return ary;
    }

    public static int[] ReverArrayPartByOptimize(int[] ary,int L,int R){

        while(L<R){

            int temp=ary[L];
            ary[L]=ary[R];
            ary[R]=temp;

            L++;
            R--;
        }

        return ary;
    }

    public static void main(String[] args){

        int[] array={3,4,5,2,6,3,10};

        int rotateCount=2;

        System.out.println(
                "BF       : "
                        + Arrays.toString(
                        RotateArrayByBFApproach(array.clone(),rotateCount)));

        System.out.println(
                "Optimized: "
                        + Arrays.toString(
                        RotateArrayByOptimizeApproach(array.clone(),rotateCount)));
    }
}