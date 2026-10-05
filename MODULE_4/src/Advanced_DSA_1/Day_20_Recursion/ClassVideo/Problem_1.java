package Advanced_DSA_1.Day_20_Recursion.ClassVideo;
/*
Q-1: calculate the sum of first n natural number using recursing
 */
public class Problem_1 {

    public static int CalculateSumOfNaturalNumber(int number){
        if(number == 1){
            return number;
        }
        return CalculateSumOfNaturalNumber(number-1)+ number;
    }

    public static void main(String[] args){
        int number = 5;
        System.out.println("sum is:"+CalculateSumOfNaturalNumber(number));
    }
}
