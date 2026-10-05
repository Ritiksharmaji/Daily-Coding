package Advanced_DSA_1.Day_24_Lab_Session_on_Hashing.ClassVideo;

import java.util.HashMap;

/*
Q-1: Given a string s, find the length of the longest substring without repeating characters
 */
public class Problem_1 {

    public static int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int maxLen = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (map.containsKey(ch)) {
                left = Math.max(left, map.get(ch) + 1);
            }

            map.put(ch, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
    public static void main(String[] args){
        System.out.println(lengthOfLongestSubstring("abcababb"));
        System.out.println(lengthOfLongestSubstring("bbbbbbb"));
    }
}
