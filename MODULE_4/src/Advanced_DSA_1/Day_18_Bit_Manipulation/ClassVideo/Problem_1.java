package Advanced_DSA_1.Day_18_Bit_Manipulation.ClassVideo;
/*
Q-1:  Check whether ith bit is set or not.
 */
public class Problem_1 {

    public static boolean CheckSetBit(int a , int index){

        if((a & (1<<index)) == 0){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args){
        int a = 35;
        int index = 5;
        System.out.println(" is Ith bit of a is set: "+ CheckSetBit(a , index));
    }
}
