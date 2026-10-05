package Advanced_DSA_1.Day_20_Recursion.ClassVideo;
// Q-3: print number in Increasing order
public class Problem_3 {

    public static void printAllNumbers(int number){
        if(number == 1){
            System.out.print(" " + number+" ");
            return;
        }
        printAllNumbers(number-1);
        System.out.print(" "+ number + " ");
    }
    public static void main(String[] args){
        int number = 5;
        printAllNumbers(number);
    }
}
