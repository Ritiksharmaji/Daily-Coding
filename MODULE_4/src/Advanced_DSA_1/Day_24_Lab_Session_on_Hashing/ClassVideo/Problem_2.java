package Advanced_DSA_1.Day_24_Lab_Session_on_Hashing.ClassVideo;

import java.util.HashMap;

/*
Q-2: Given N elements, find the first non-repeating element
 */
public class Problem_2 {
    public static int firstNonRepeating(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Find first non-repeating
        for (int num : arr) {
            if (map.get(num) == 1) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 2, 0, 4};
        System.out.println(firstNonRepeating(arr));
    }
}

