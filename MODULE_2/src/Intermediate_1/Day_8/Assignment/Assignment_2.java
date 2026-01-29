package src.Intermediate_1.Day_8.Assignment;

// Q2. Maximum Subarray Easy
public class Assignment_2 {
    public static void main(String[] args) {

        int[] a = {2, 1, 3, 4, 1};
        int b = 7;

        int left = 0;
        int sum = 0;
        int ans = 0;

        for (int right = 0; right < a.length; right++) {

            sum += a[right];   // expand window

            while (sum > b) { // shrink window
                sum -= a[left];
                left++;
            }

            ans = Math.max(ans, sum);
        }

        System.out.println("Max sum: " + ans);
    }
}
