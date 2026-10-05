package src.Intermediate_1.Day_4_Intermediate_DSA_Introduction_to_Arrays.ClassVideo;

import java.util.Arrays;

/*
problem-2: given a array need to rever the given part of array
 */
public class Problem_2 {
//    public static int[] ReverArrayPartByBFApproach(int[] ary, int L, int R){
//
//        int[] ans = new int[ary.length];
//        int j = 0;
//        for(int i = ary.length-1; i>= 0; i--){
//            if(i >= L && i <= R){
//                ary[i] = ary[R];
//                ary[R] = ary[L];
//                R--;
//                L++;
//            }
//        }
//        return ans;
//    }
    public  static int[] ReverArrayPartByOptimize(int[] ary,int L, int R){
        while(L < R){
            int temp = ary[L];
            ary[L] = ary[R];
            ary[R] = temp;
            L++;
            R--;
        }
        return ary;
    }
    public static void main(String[] args){
        int[] array = {3,4,5,2,6,3,10};
        int L = 1, R = 5;
        //System.out.println(" reverse part of array By BF : "+ Arrays.toString(ReverArrayPartByBFApproach(array,L, R)));
        System.out.println(" reverse part of array By Optimize : "+ Arrays.toString(ReverArrayPartByOptimize(array,L, R)));

    }
}
