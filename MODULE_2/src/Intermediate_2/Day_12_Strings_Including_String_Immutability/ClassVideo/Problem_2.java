package src.Intermediate_2.Day_12_Strings_Including_String_Immutability.ClassVideo;
/*
## --- Problem-2: Check Whether the given String is Palindrome or not.

 */
public class Problem_2 {
    public static boolean CheckStringIsPalidromOrNot(String s){
        int startIndex = 0, endIndex = s.length() -1 ;
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
      String a  = "mamta";
      //  String a  = "madam";
        System.out.println("Original String is :"+ a + " and after toggle String is :  "+ CheckStringIsPalidromOrNot(a));
    }
}
