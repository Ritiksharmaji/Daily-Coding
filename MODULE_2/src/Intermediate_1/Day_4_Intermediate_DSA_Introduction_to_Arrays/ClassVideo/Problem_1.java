package src.Intermediate_1.Day_4_Intermediate_DSA_Introduction_to_Arrays.ClassVideo;

import java.util.Arrays;
/*
problem-1: given a array size n you need to revers the array
 */
public class Problem_1 {
    public  static int[] ReverArrayByBFApproach(int[] ary){
        int[] ans = new int[ary.length];
        int index = 0;
        for(int i = ary.length - 1 ; i >= 0; i--){
            ans[index] = ary[i];
            index++;
        }

        return ans;
    }

    // rever array with respect to two pointers
    public static int[] ReverArrayByOptimize(int[] ary){
        // int[] ans = new int[ary.length];
        int i = 0 , j = ary.length - 1;
        while (i < j){
            int temp = ary[i];
            ary[i] = ary[j];
            ary[j] = temp;
            i++;
            j--;
        }
        return ary;
    }


    public static void main(String[] args){
        int[] array = {3,4,5,2,6,3,10};
        System.out.println("reverse the array with BF :"+ Arrays.toString(ReverArrayByBFApproach(array)));
        System.out.println("reverse the array with Optimize  :"+ Arrays.toString(ReverArrayByOptimize(array)));

    }
}
