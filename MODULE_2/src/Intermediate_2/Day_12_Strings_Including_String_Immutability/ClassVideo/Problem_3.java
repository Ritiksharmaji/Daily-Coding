package src.Intermediate_2.Day_12_Strings_Including_String_Immutability.ClassVideo;
/*
## --- Problem-3: Check whether the given Sub-String is Palindrome or not.

 */
public class Problem_3 {
    public static boolean CheckSubStringIsPalidromOrNot(String s, int startIndex, int endIndex ){
        while (startIndex < endIndex){
            if(s.charAt(startIndex) == s.charAt(endIndex)){
                startIndex++;
                endIndex--;
            }else{
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        String a  = "rrrrrrrrrrrrrrrrrrrrrrrrr";
        int startIndex = 3, endIndex = 8;
        //  String a  = "madam";
        System.out.println("Original String is :"+ a + " and after toggle String is :  "+ CheckSubStringIsPalidromOrNot(a, startIndex, endIndex));
    }
}
