package src.Intermediate_2.Day_12_Strings_Including_String_Immutability.ClassVideo;

import static src.Intermediate_2.Day_12_Strings_Including_String_Immutability.ClassVideo.Problem_3.CheckSubStringIsPalidromOrNot;

/*
## --- Problem-4: Given a String s , calculate Length of longest palindromic substring.

 */
public class Problem_4 {

    public static int LongestPalindromicSubstring(String s ){
        // step-1: check palindrome number
        // if yes then compare the length and return it
        int longestLength = Integer.MIN_VALUE;

        for(int startIndex = 0; startIndex<s.length(); startIndex++) {
            for(int endIndex = startIndex; endIndex <s.length(); endIndex++){
                if(CheckSubStringIsPalidromOrNot(s, startIndex,endIndex )){
                    longestLength = Math.max(longestLength,(endIndex - startIndex + 1));
                }

            }
        }

        return longestLength;
    }

    public static void main(String[] args){
       // String a  = "abacab";

         String a  = "fcacabacabgf";
        System.out.println("Original String is :"+ a + " and after toggle String is :  "+ LongestPalindromicSubstring(a));
    }
}
