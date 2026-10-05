package Advanced_DSA_1.Day_18_Bit_Manipulation.ClassVideo;
/*
    Q-4  given an array of size N. where every element occures twice except one element .
    identify that element
 */
public class Problem_4 {

    // method -1:
    public static void FindUniqueElement(int[]a, int n){
        int ans = 0;
        for(int i = 0; i<n; i++){
            ans = ans ^ a[i];
        }
        System.out.println("final unique value is :"+ans);
    }

    // method -2:
    public static void FindUniqueElementMethod_2(int[]a, int n){

    }

    public static void main(String[] args){
        int[] a = {4,5,5, 4, 6, 6,1};
        FindUniqueElement(a, a.length);
    }
}
