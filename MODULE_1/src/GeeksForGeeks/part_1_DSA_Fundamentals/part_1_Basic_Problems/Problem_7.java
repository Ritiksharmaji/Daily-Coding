package GeeksForGeeks.part_1_DSA_Fundamentals.part_1_Basic_Problems;

// Q:7 The dice problem

// ans: [Naive Approach]  -Time Complexity: O(1) Time and Auxiliary Space: O(1)
//public class Problem_7 {
//    public static int oppositeFaceOfDice(int n)
//    {
//        int ans;
//        if (n == 1) {
//            ans = 6;
//        }
//        else if (n == 2) {
//            ans = 5;
//        }
//        else if (n == 3) {
//            ans = 4;
//        }
//        else if (n == 4) {
//            ans = 3;
//        }
//        else if (n == 5) {
//            ans = 2;
//        }
//        else {
//            ans = 1;
//        }
//        return ans;
//    }
//
//    public static void main(String[] args)
//    {
//        int n = 2;
//        System.out.println(oppositeFaceOfDice(n));
//    }
//}

/*
[Expected Approach]-Using Sum of Two Sides
The idea is based on the observation that the sum of two opposite sides of a
cubical dice is equal to 7. So, just subtract the given n from 7 and print the answer.
 */
public class Problem_7 {
    public static int oppositeFaceOfDice(int n) {
        // Stores number on opposite face
        // of dice
        return 7 - n;
    }
    public static void main(String[] args) {
        int n = 2;
        System.out.println(oppositeFaceOfDice(n));
    }
}
