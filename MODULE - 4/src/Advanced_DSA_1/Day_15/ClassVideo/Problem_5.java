//package Advanced_DSA_1.Day_15.ClassVideo;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//// Q-3: Each query (i, j,x) means Add x to all elements from index i to N-1
//public class Problem_5 {
//    // optimize apporach
//    public static void main(String[] args) {
//
//        List<int[]> intervals = new ArrayList<>();
//        intervals.add(new int[]{1, 3});
//        intervals.add(new int[]{2, 6});
//        intervals.add(new int[]{8, 10});
//        intervals.add(new int[]{15, 18});
//
//
//
//// Step 1: process queries
//        for (int[] q : queries) {
//            int l = q[0];
//            int r = q[1];
//            int x = q[2];
//
//            diff[l] += x;
//            if (r + 1 < A.length) {
//                diff[r + 1] -= x;
//            }
//        }
//
//// Step 2: prefix sum
//        A[0] = diff[0];
//        for (int i = 1; i < A.length; i++) {
//            A[i] = A[i - 1] + diff[i];
//        }
//
//
//        System.out.println(Arrays.toString(A));
//    }
//}
