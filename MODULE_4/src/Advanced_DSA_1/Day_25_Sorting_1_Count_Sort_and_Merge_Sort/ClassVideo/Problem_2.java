package Advanced_DSA_1.Day_25_Sorting_1_Count_Sort_and_Merge_Sort.ClassVideo;

import java.util.Arrays;

/*
Q-2: Marge two Sorted array
 */
public class Problem_2 {
    private static int[] MargeTwoSortArray(int[] array, int[] array2) {
        int n = array.length, m = array2.length;
        int i = 0, j = 0, index = 0;
        int[] ans = new int[n+m];
        while (i < n && j < m){
            if(array[i] <= array2[j]){
                ans[index] = array[i];
                i++;
                index++;
            }else{
                ans[index] = array2[j];
                j++;
                index++;
            }
        }
        // handle i out of bound
        while ( i < n){
            ans[index] = array[i];
            i++;
            index++;

        }
        // handle j out of bound
        while ( j < m){
            ans[index] = array2[j];
            j++;
            index++;

        }
        return ans;
    }
    public static void main(String[] args){

        int[] array = {2,4,7,8,12};
        int[] array2 = {3,5,6,7};

        int[] ans = MargeTwoSortArray(array, array2);

        System.out.println(Arrays.toString(ans));

    }


}
