package Advanced_DSA_1.Day_24_Lab_Session_on_Hashing.ClassVideo;

import java.util.HashSet;

/*
Q-3: Given an array of N elements, check if there exists a subarray with a sum equal to 0
 */
public class Problem_3 {
    public static boolean subarraySumZero(int[] arr) {

        HashSet<Integer> set = new HashSet<>();
        int prefixSum = 0;

        for (int num : arr) {

            prefixSum += num;

            if (prefixSum == 0) {
                return true;
            }

            if (set.contains(prefixSum)) {
                return true;
            }

            set.add(prefixSum);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6};
        System.out.println(subarraySumZero(arr));
    }
}
