package GeeksForGeeks.part_1_DSA_Fundamentals.part_1_Basic_Problems;

import java.util.Scanner;

// Q:4 Program for Sum of squares of first n natural numbers

// ans: using Naive Approach] Using Loop - O(n) Time and O(1) Space
//public class Problem_4 {
//
//    public static void main(String args[]){
//        System.out.println("enter a natural number to print sum of nth square ");
//        Scanner sc = new Scanner(System.in);
//        int number = sc.nextInt();
//        int sum = 0;
//        System.out.println("Enter a square number");
//        int square_number = sc.nextInt();
//
//        for(int i =1; i<=number; i++){
//            sum+=(i * square_number);
//        }
//        System.out.println("total sum of square "+ number + "numbers is:"+ sum);
//    }
//}

// optimize: [Expected Approach]- Using Mathematical Formulae - O(1) Time and O(1) Space
public class Problem_4 {

    public static int summation(int n)
    {
        return (n * (n + 1) *
                (2 * n + 1)) / 6;
    }
    public static void main(String args[]){
        System.out.println("enter a natural number to print square of nth ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int sum = summation(number);
        System.out.println("total sum of square "+ number + "numbers is:"+ sum);
    }
}
