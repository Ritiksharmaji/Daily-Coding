package Advanced_DSA_1.Day_22_Math_Modular_Arithmetic_and_GCD.ClassVideo;
/*
Find GCD of Entire Array
 */
public class Problem_3 {

    // Euclidean Algorithm
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int findGCD(int[] arr) {
        int ans = arr[0];

        for (int i = 1; i < arr.length; i++) {
            ans = gcd(ans, arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {6, 12, 15};
        System.out.println(findGCD(arr));
    }
}
