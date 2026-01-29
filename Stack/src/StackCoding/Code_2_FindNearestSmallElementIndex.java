package StackCoding;

// BF approach:
//public class Code_2_FindNearestSmallElementIndex {
//    public static void main(String[] args) {
//        int[] A = {4, 6, 3, 2, 1, 9};
//        int n = A.length;
//        int[] result = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            result[i] = -1;   // default
//            for (int j = i - 1; j >= 0; j--) {
//                if (A[j] < A[i]) {
//                    result[i] = j;
//                    break;   // nearest found
//                }
//            }
//        }
//        for (int x : result)
//            System.out.print(x + " ");
//    }
//}

import java.util.Stack;

// optimize approach -2: using Stack
public class Code_2_FindNearestSmallElementIndex {
    public static void main(String[] args) {
        int[] A = {4, 6, 3, 2, 1, 9};
        int n = A.length;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && A[st.peek()] >= A[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }

            st.push(i);
        }
        for (int x : result)
            System.out.print(x + " ");

    }
}
