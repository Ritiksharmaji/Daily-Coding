package Advanced_DSA_1.Day_19_Lab_Session_on_Bit_Manipulation.ClassVideo;
/*
Q-3: subarrays having OR(given a binary array,
find total number of subarrays the bitwise OR of which is 1)---
 */
public class Problem_3 {

    public static int FindTotalBitWiseORByMethodOne(int[] array){
        int count = 0;

        for(int i = 0; i<array.length; i++){
            for(int j = i; j<array.length;j++){
                count = count + (array[i] | array[j]);
            }
        }
        return count;
    }

    public static int FindTotalBitWiseORByMethodTwo(int[] arrary){
        return 1;
    }

    public static void main(String[] args){
//        int[] a = {1,0,1};
        int[] a = {0,0,1,1,0};
        int totalCountOne = FindTotalBitWiseORByMethodOne(a);
        int totalCounttwo = FindTotalBitWiseORByMethodTwo(a);
        System.out.println("total 1 of given array in bitwsie OR are: "+ totalCountOne);
    }
}
