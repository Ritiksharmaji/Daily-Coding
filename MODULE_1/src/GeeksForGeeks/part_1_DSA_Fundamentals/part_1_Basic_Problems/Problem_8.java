package GeeksForGeeks.part_1_DSA_Fundamentals.part_1_Basic_Problems;

// Q:8 Nth Term of AP(Nth term of AP from First Two Terms)

import java.util.Arrays;

public class Problem_8 {
    // creating prefix-sum
    public static int[] prefix(int[] a , int variant,int first){
        int[] prefix = new int[a.length];
        prefix[0] = first;
        for(int i = 1; i<a.length; i++){
            prefix[i] = variant + prefix[i-1];
        }
        return prefix;
    }

    public static void main(String[] args)
    {
        int a1 = 1, a2=3 , x = 10;
        int variant = a2 - a1;
        int[] array = new int[x];

        int[] ans = prefix(array, variant, a1);
        System.out.println("array is:"+ Arrays.toString(ans));
    }
}

/*
[Expected Approach]-Using Sum of Two Sides
The idea is based on the observation that the sum of two opposite sides of a
cubical dice is equal to 7. So, just subtract the given n from 7 and print the answer.
 */
//public class Problem_8 {
//
//}
