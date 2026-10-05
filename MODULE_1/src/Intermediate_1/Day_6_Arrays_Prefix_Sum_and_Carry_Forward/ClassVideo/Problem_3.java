package Intermediate_1.Day_6_Arrays_Prefix_Sum_and_Carry_Forward.ClassVideo;

/*
Problem-3:
Given a String s of lowercase characters,
count all pairs (i, j) such that

i < j
s[i] == 'a'
s[j] == 'g'
*/

public class Problem_3 {

    // =====================================================
    // Method-1 : Brute Force
    // Time : O(N²)
    // Space : O(1)
    // =====================================================
    public static int countPairByBF(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a') {

                for (int j = i + 1; j < s.length(); j++) {

                    if (s.charAt(j) == 'g') {
                        ans++;
                    }
                }
            }
        }

        return ans;
    }

    // =====================================================
    // Method-2 : Better
    // Count G separately for every A
    // Time : O(N²)
    // Space : O(1)
    // =====================================================
    public static int countPairByBetter(String s) {

        int ans = 0;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a') {

                int gCount = 0;

                for (int j = i + 1; j < s.length(); j++) {

                    if (s.charAt(j) == 'g') {
                        gCount++;
                    }
                }

                ans += gCount;
            }
        }

        return ans;
    }

    // =====================================================
    // Method-3 : Optimized (Carry Forward)
    // Time : O(N)
    // Space : O(1)
    // =====================================================
    public static int countPairByOptimize(String s) {

        int gCount = 0;
        int ans = 0;

        for (int i = s.length() - 1; i >= 0; i--) {

            if (s.charAt(i) == 'g') {
                gCount++;
            }

            if (s.charAt(i) == 'a') {
                ans += gCount;
            }
        }

        return ans;
    }

    // =====================================================
    // Main Method
    // =====================================================
    public static void main(String[] args) {

        String s = "abegag";

        System.out.println("String : " + s);

        System.out.println("Brute Force : " + countPairByBF(s));

        System.out.println("Better      : " + countPairByBetter(s));

        System.out.println("Optimized   : " + countPairByOptimize(s));
    }
}