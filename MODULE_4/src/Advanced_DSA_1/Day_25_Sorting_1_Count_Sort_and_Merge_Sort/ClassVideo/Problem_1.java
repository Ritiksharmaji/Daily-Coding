package Advanced_DSA_1.Day_25_Sorting_1_Count_Sort_and_Merge_Sort.ClassVideo;

import java.util.Arrays;

public class Problem_1 {

    public static int[] CountSortGivenArray(int[] ary){

        int minValue = FindMinValue(ary);
        int maxValue = FindMaxValue(ary);

        int range = maxValue - minValue + 1;

        int[] freq = new int[range];

        int[] ans = new int[ary.length];

        // Build frequency array
        for(int i = 0; i < ary.length; i++){
            freq[ary[i] - minValue]++;
        }

        int index = 0;

        // Rebuild sorted array
        for(int i = 0; i < range; i++){

            for(int j = 0; j < freq[i]; j++){

                ans[index] = i + minValue;

                index++;

            }

        }

        return ans;
    }

    public static int FindMinValue(int[] ary){

        int min = ary[0];

        for(int i = 1; i < ary.length; i++){

            if(ary[i] < min){

                min = ary[i];

            }

        }

        return min;
    }

    public static int FindMaxValue(int[] ary){

        int max = ary[0];

        for(int i = 1; i < ary.length; i++){

            if(ary[i] > max){

                max = ary[i];

            }

        }

        return max;
    }

    public static void main(String[] args){

        int[] array = {-2,3,8,3,-2,3};

        int[] ans = CountSortGivenArray(array);

        System.out.println(Arrays.toString(ans));

    }

}