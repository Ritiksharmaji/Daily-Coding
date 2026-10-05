package Advanced_DSA_1.Day_18_Bit_Manipulation.ClassVideo;
/*
Q-2:  set the iTH bit if it is unset and if it is set then left it.
 */
public class Problem_2 {
    public static void SetUnsetBit(int a , int index){
        int setIndex = a;
        if((a & (1<< index)) == 0){
            // it means ith in unset
            setIndex = (a ^ (1<< index));
            System.out.println("after setting the unset bit value of a is: "+ setIndex);
        }else{
            System.out.println("default value a is :"+ a);
        }

    }
    public static void main(String[] args){
        int a = 45 ;
        int index = 4;
        SetUnsetBit(a, index);
    }
}
