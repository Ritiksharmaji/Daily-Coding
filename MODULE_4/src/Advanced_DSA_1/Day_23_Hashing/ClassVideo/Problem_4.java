package Advanced_DSA_1.Day_23_Hashing.ClassVideo;

import java.util.HashMap;

/*
Count pairs(i, j) such that, arr[i] + arr[j] == K && i != j in the given array.
A = [3, 5, 1, 2, 1, 2] and K = 3.
Note that (i, j) and (j, i) considered as same.
 */
public class Problem_4 {
    public static int pairSumOptimized(int[] arr, int K) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int num : arr) {

            int target = K - num;

            if (map.containsKey(target)) {
                count += map.get(target);
            }

            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args){
        int[] A ={3,5,9,2};
        int num = 7;
        System.out.print(pairSumOptimized(A, num));
    }
}
