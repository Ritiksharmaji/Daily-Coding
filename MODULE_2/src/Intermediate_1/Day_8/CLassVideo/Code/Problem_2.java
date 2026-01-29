package src.Intermediate_1.Day_8.CLassVideo.Code;

// Q: Print start and end index of subarrays of size k (Sliding Window)
public class Problem_2 {
    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5, 6, 7, 8};
        int k = 3;

        int startIndex = 0;
        int endIndex = k - 1;

        while (endIndex < a.length) {
            System.out.println(
                    "Start index of subarray: " + startIndex +
                            " | End index of subarray: " + endIndex
            );

            startIndex++;
            endIndex++;
        }
    }
}
