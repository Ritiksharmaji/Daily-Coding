package Advanced_DSA_1.Day_20_Recursion.ClassVideo;
// Q-4: print nth number in fibonacci seris
public class Problem_4 {

    public static int PrintNumberFibonacci(int n){
        if(n <= 1){
            return n;
        }
        return PrintNumberFibonacci(n-1) + PrintNumberFibonacci(n-2);
    }
    public static void main(String[] args){
        int number = 4;
       System.out.print( " " + PrintNumberFibonacci(number) + " ");
    }
}
