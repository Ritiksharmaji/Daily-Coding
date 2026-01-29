package src.Intermediate_1.Day_8.Assignment;

public class Assignment_3 {
    public static void main(String[] args) {

        int[] a = {4, 3, 2, 6, 1};
        int b = 3;
        int c = 11;

        int sum = 0;
        int ans = 0;

        // Step 1: First window
        for (int i = 0; i < b; i++) {
            sum += a[i];
        }

        // Check first window
        if (sum == c) {
            ans = 1;
        }

        // Step 2: Slide the window
        for (int i = b; i < a.length && ans == 0; i++) {
            sum += a[i];
            sum -= a[i - b];

            if (sum == c) {
                ans = 1;
            }
        }

        System.out.println(ans);
    }
}
