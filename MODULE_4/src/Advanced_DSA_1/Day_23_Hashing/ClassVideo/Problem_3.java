package Advanced_DSA_1.Day_23_Hashing.ClassVideo;

import java.util.HashSet;

/*
Given arr[N] and K, check if there exists a pair(i, j) such that, arr[i] + arr[j] == K && i != j
 */
public class Problem_3 {
    public static boolean pairSumOptimized(int[] arr, int K) {
        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            int target = K - num;

            if (set.contains(target)) {
                return true;
            }

            set.add(num);
        }

        return false;
    }

    public static void main(String[] args){
        int[] A ={3,5,9,2};
        int num = 7;
        System.out.print(pairSumOptimized(A, num));
    }
}
