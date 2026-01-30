package GeeksForGeeks.part_1_DSA_Fundamentals.part_1_Basic_Problems;

import java.util.Scanner;

// Q:2 Program for sum of n natural numbers

// ans: using Naive Approach] Using Loop - O(n) Time and O(1) Space
//public class Problem_3 {
//
//    public static void main(String args[]){
//        System.out.println("enter a natural number to print sum of it ");
//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        int sum = 0;
//
//        for(int i =1; i<=number; i++){
//            sum+=i;
//        }
//        System.out.println("total sum of "+ number + "numbers is:"+ sum);
//    }
//}

// opimize:
public class Problem_3 {

    static int findSum(int n)
    {
        // Using mathematical formula to compute
        // sum of first n natural numbers
        return n * (n + 1) / 2;
    }
    public static void main(String args[]){
        System.out.println("enter a natural number to print sum of it ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = findSum(number);
        System.out.println("total sum of "+ number + "numbers is:"+ sum);
    }
}
