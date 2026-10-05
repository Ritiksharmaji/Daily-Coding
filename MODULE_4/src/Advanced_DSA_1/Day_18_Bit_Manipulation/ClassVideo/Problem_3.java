package Advanced_DSA_1.Day_18_Bit_Manipulation.ClassVideo;
/*
Q-3: UnSet the ith bit of a number if it is set
 */
public class Problem_3 {

    public static void UnsetBit(int a , int index ){
        int unsetValue = a;
        if((a & (1<< index)) != 0){
            unsetValue = (a ^ (1<< index));
            System.out.println("after unset the ith bit of a number is :"+ unsetValue);
        }else{
            System.out.println("default value is :"+ a);
        }
    }

    public static void main(String[] args){
        int a = 6 ;
        int index = 2;
        UnsetBit(a, index);
    }
}
