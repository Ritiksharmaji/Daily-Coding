package GeeksForGeeks.part_1_DSA_Fundamentals.part_1_Basic_Problems;

// Q:5 Find Closest to n and Divisible by m

// ans: [Naive Approach] Iterative Checking - O(m) Time and O(1) Space
//public class Problem_6 {
//    public static int closestDivisibleBF(int n, int m) {
//        // Absolute m to avoid issues
//        m = Math.abs(m);
//
//        for (int d = 0; d <= m; d++) {
//
//            int lower = n - d;
//            int upper = n + d;
//
//            // Check upper first to handle tie case (return larger)
//            if (upper % m == 0) {
//                return upper;
//            }
//
//            if (lower % m == 0) {
//                return lower;
//            }
//        }
//
//        return n; // fallback (never actually reached)
//    }
//
//    public static void main(String[] args) {
//        System.out.println(closestDivisibleBF(13, 4)); // 12
//        System.out.println(closestDivisibleBF(14, 4)); // 16
//    }
//}

 // [Expected Approach] Without using Third Variable
public class Problem_6 {

        public static int closestDivisible(int n , int m){

            // step-1: find the reminder
            int r = n % m;
            // ege case
            if (r == 0) return n;

            //step-2: find the lowest near value and higher near value of n
            int lower = n - r ;
            int higher = n + (m-r);
            // step-3: If tie, return larger
            if (n - lower < higher - n) {
                return lower;
            } else {
                return higher;
            }
        }
    public static void main(String[] args){
        System.out.println(closestDivisible(13, 4)); // 12
        System.out.println(closestDivisible(14, 4)); // 16
    }
}
