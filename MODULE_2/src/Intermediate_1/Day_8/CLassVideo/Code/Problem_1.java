package src.Intermediate_1.Day_8.CLassVideo.Code;
// Q-2: find total subarray of a array with length k (Sliding window)
public class Problem_1 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;
        int arrLength = a.length;
        int totalSubarrays = arrLength - k + 1;
        System.out.println("Total subarrays of length " + k + " is: " + totalSubarrays);

    }
}

