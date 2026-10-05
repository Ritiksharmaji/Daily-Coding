package src.Intermediate_1.Day_2_Intermediate_DSA_Time_Complexity.Assignment;
/*
Q2. Count Factors - 2(Given an integer A, you need to find the count of it's factors.)
 */
public class Assignment_1 {
    public static int solve(int A) {
        int count = 0;
        for(int i = 1; i<= A ; i++){
            if(A%i == 0){
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println("total factor of give number is:"+ solve(3));
    }

}
