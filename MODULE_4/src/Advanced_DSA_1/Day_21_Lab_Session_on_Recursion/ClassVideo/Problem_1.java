package Advanced_DSA_1.Day_21_Lab_Session_on_Recursion.ClassVideo;
/*
Q-1: implement the power function( given two integer a and n return an a^n)
 */
public class Problem_1 {

    public static int pow(int a , int n){
        if(n == 0) return 1;
        int  p = pow(a,n/2);
        if(n% 2 == 0){
            return p * p;
        }else{
            return p * p * a;
        }
    }
    public static void main(String[] args){

        int a = 2;
        int n = 3;
        System.out.print(pow(a,n));

    }
}
