package Advanced_DSA_1.Day_20_Recursion.ClassVideo;
// Q-5: print an array recursively
public class Problem_5 {

    public static void printArray(int[] arr, int index) {
        // base case
        if (index == arr.length) {
            return;
        }

        // print current element
        System.out.print(arr[index] + " ");

        // recursive call
        printArray(arr, index + 1);
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        printArray(arr, 0);
    }
}
