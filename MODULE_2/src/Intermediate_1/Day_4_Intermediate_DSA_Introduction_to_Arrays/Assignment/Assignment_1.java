package src.Intermediate_1.Day_4_Intermediate_DSA_Introduction_to_Arrays.Assignment;

/*
Q1. Good Pair ( Given an array A and an integer B. A pair(i, j)
in the array is a good pair if i != j and (A[i] + A[j]  B).
Check if any good pair exist or not.) -----
 */
public class Assignment_1 {
    public  static boolean CheckGoodPairByBF(int[] ary, int b){
        for(int i = 0 ; i<ary.length; i++){
            for(int j = i+1; j<ary.length; j++){
                if(ary[i] + ary[j] == b && i != j){
                    return true;
                }
            }
        }
        return false;
    }


    // by optimize
    public static boolean CheckGoodPairByOptimize(int[] ary, int b){


        return false;
    }

    public static void main(String[] args){
        int[] array = {3,4,5,2,6,3,10};
        int b = 9;
        System.out.println("reverse the array with BF :"+ (CheckGoodPairByBF(array, b)));
       System.out.println("reverse the array with Optimize  :"+ (CheckGoodPairByOptimize(array, b)));

    }
}
