package Intermediate_2.Day_9_Lab_Session_Memory_Management_and_Sorting_Basics.ClassVideo;

import java.util.Arrays;

/*
## -- Problem-1: In an array of N elements, find count of nobel integers, A[i] is Noble if count of smaller elements of A[i] should equal to A[i].

 */
public class Problem_1 {

    public static int FindTotalNobleElementsByOptimize(int[] ary){
        // TC = Nlog(N)
        ary = Arrays.stream(ary).sorted().toArray();
        System.out.println("after sorting ary is: " + Arrays.toString(ary.clone()));
        int count = 0,  ans = 0;
        if(ary[0] == 0){
            ans++;
        }
        for(int i = 1; i<ary.length; i++){
            if(ary[i] != ary[i-1]){
                count = i;

            if(count == ary[i]){
                ans++;
            }
            }
        }
        return ans;
    }


    public static void main(String[] args){
//        int[] array = {-10,-5,1,3,4,2,6};
       // int[] array = {-10,1,1,2,4,4,4,8,10};
        int[] array = {1,-5,3,5,-10,4};
        int totalNobleCountByOptimize = FindTotalNobleElementsByOptimize(array);
        System.out.println("total Noble elements are : "+ totalNobleCountByOptimize);
    }
}
