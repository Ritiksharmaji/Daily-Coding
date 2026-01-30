package GeeksForGeeks.part_1_DSA_Fundamentals.part_1_Basic_Problems;

import java.util.Scanner;

// Q:5 Swap Two Numbers

// ans: [Naive Approach] Using Third Variable
//public class Problem_5 {
//
//    public static void swapTwoValue(int a , int b){
//        System.out.println("Before swap value of a is:"+ a + " b is:"+ b);
//        int c = a ;
//        a = b;
//        b = c;
//        System.out.println("after swap value of a is:"+ a + " b is:"+ b);
//    }
//    public static void main(String[] args){
//       int a = 9, b= 8;
//       swapTwoValue(a,b);
//    }
//}

// [Expected Approach] Without using Third Variable
public class Problem_5 {

        public static void swapTwoValue(int a , int b){
        System.out.println("Before swap value of a is:"+ a + " b is:"+ b);
        a = a + b;
        b = a -b ;
        a = a- b;
        System.out.println("after swap value of a is:"+ a + " b is:"+ b);
    }
    public static void main(String[] args){
       int a = 9, b= 8;
       swapTwoValue(a,b);
    }
}
