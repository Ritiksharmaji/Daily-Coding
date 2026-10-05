package Advanced_DSA_1.Day_16_Two_Dimensional.ClassVideo;

public class Problem_3 {

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int firstMissingPositive(int[] array){
        int i = 0;

        // Step 1: Place elements at correct index
        while(i < array.length){
            int correctIndex = array[i] - 1;

            if(array[i] >= 1 && array[i] <= array.length
                    && array[i] != array[correctIndex]){
                swap(array, i, correctIndex);
            } else {
                i++;
            }
        }

        // Step 2: Find missing
        for(int j = 0; j < array.length; j++){
            if(array[j] != j + 1){
                return j + 1;
            }
        }
        return array.length + 1;
    }

    public static void main(String[] args){
        int[] array = {3, 4, -1, 1};
        int ans = firstMissingPositive(array);
        System.out.println("Missing value is: " + ans);
    }
}
