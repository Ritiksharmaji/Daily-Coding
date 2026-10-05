package Advanced_DSA_1.Day_23_Hashing.ClassVideo;

import java.util.HashSet;

/*
Q-2: Given an array of N elements, find the count of distinct elements.
 */
public class Problem_2 {

    public static int countDistinctOptimized(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        return set.size();
    }
    public static void main(String[] args){
        int[] A= {1,2,2,3,4,4,5};
        System.out.print(countDistinctOptimized(A));
    }
}
