package Advanced_DSA_1.Day_24_Lab_Session_on_Hashing.ClassVideo;

import java.util.HashSet;

/*
Q-4: Given an array arr[n] check if there exists a subarray with sum = K
 */
public class Problem_4 {

    public static boolean subarraySumK(int[] arr, int K) {

        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;

        for (int num : arr) {

            prefixSum += num;

            if (prefixSum == K) {
                return true;
            }

            if (set.contains(prefixSum - K)) {
                return true;
            }

            set.add(prefixSum);
        }

        return false;
    }
    public static void main(String[] args) {
        int[] arr = {1, 4, 20, 3, 10, 5};
        int k = 33;
        System.out.println(subarraySumK(arr,k));
    }
}
