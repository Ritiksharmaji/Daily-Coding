package GeeksForGeeks.part_1_DSA_Fundamentals.part_1_Basic_Problems;

import java.util.Scanner;

// Q:2 Given a number n, we need to print its table.
public class Problem_2 {

    public static void main(String args[]){
        System.out.println("enter number to print table");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.println("Enter table count number:");
        int tablecount = sc.nextInt();
        for(int i =1; i<=tablecount; i++){
            System.out.println(number + "*" + i + " = "+ number*i);
        }

    }
}
