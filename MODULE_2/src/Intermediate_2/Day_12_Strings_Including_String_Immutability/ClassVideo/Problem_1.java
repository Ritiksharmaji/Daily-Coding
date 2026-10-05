package src.Intermediate_2.Day_12_Strings_Including_String_Immutability.ClassVideo;
/*
## --- Problem-1: Given a String, toggle every character Note-: input has small & Capital chars.

 */
public class Problem_1 {
    public static String ToggleString(String s){

        String ans = "";

        for(int i = 0; i < s.length(); i++){

            char ch = s.charAt(i);

            if(ch >= 'A' && ch <= 'Z'){
                ans += (char)(ch + 32);
            }else if(ch >= 'a' && ch <= 'z'){
                ans += (char)(ch - 32);
            }else{
                ans += ch;
            }
        }

        return ans;
    }

    public static void main(String[] args){
        String a  = "Ritik sharma";
        System.out.println("Original String is :"+ a + " and after toggle String is :  "+ ToggleString(a));
    }
}
