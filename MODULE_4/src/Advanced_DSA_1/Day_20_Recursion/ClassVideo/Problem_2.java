package Advanced_DSA_1.Day_20_Recursion.ClassVideo;
// Q-2: given a number n print the factorial of n
public class Problem_2 {

    public static int CalculateFactorialOfNumber(int n){
        if(n == 1){
            return n;
        }
        return CalculateFactorialOfNumber(n-1) * n;
    }

    public static void main(String[] args){
        int number = 5;
        System.out.println("factorial of "+ number+ ": is: "+CalculateFactorialOfNumber(number));
    }
}
