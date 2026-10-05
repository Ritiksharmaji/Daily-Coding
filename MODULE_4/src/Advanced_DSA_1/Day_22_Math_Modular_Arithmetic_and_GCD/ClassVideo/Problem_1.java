package Advanced_DSA_1.Day_22_Math_Modular_Arithmetic_and_GCD.ClassVideo;
/*
Given N array elements. Find the count of pairs ( i, j )
such that ( arr [ i ] + arr [ j ] ) % m = 0 NOTE : i != j and
pair ( i , j ) is same as pair ( j , i )
 */
public class Problem_1 {

    public static int countPairsOptimal(int[] arr, int m){

        int[] freq = new int[m];

        for(int val : arr){
            int rem = val % m;
            freq[rem]++;
        }

        int count = 0;

        // remainder 0
        count += (freq[0] * (freq[0]-1))/2;

        // middle remainder
        if(m % 2 == 0){
            count += (freq[m/2] * (freq[m/2]-1))/2;
        }

        for(int r=1; r<= (m-1)/2 ; r++){
            count += freq[r] * freq[m-r];
        }

        return count;
    }

    public static void main(String[] args){
        int[] arr = {1,2,3,4,5};
        int m = 3;
        System.out.print(countPairsOptimal(arr, m));
    }
}
