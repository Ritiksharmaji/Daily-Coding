package src.Intermediate_1.Day_7_Lab_Session_on_Prefix_Sum_and_Carry_Forward.ClassVideo;
/*
Problem-4: Number of Even numbers in given
range(Given an array of size N and Q queries with L and R for every query return
count of even elements from L to R (related to PF-Sum)----

 */
public class Problem_4 {

    public static int CalculateTotalEvenNumberByOptimize(int[] ary, int[][] queries){
        // step-1: calculate PFsum
        int[] prefix = new int[ary.length];
        int totalEvenNumber = 0;
        if(ary[0]%2 == 0){
            prefix[0] = 1;
        }else{
            prefix[0] = 0;
        }
        for(int i = 1; i<ary.length; i++){

            if(ary[i] % 2 == 0){
                prefix[i] = prefix[i-1] + 1;
            }else{
                prefix[i]= prefix[i-1];
            }
        }
        //
        for(int i = 0 ; i<queries.length; i++){

            int left = queries[i][0];
            int right = queries[i][1];
            if(left == 0){
                totalEvenNumber = prefix[right];
            }else{
                totalEvenNumber = prefix[right] - prefix[left -1];
            }
            System.out.println("Query (" + left + "," + right + ") = " + totalEvenNumber);
        }
return totalEvenNumber;
    }
    public static void main(String[] args){

        int[] array = {2,7,9,3,6,8,5};

        int[][] queries = {
                {1, 2},
                {0, 5}
        };

        int totalEvenNumber = CalculateTotalEvenNumberByOptimize(array, queries);
        System.out.println("totalEvenNumber: "+totalEvenNumber);
    }
}
