package Advanced_DSA_2.Day_35_Stack.Assignments;

import java.util.Stack;

public class Assigment_2 {

    public static int EitherBalancedParenthesis(String a) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < a.length(); i++) {
            char ch = a.charAt(i);

            // Step 1: Opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Step 2: Closing brackets
            else {
                if (stack.isEmpty()) {
                    return 0;
                }

                char top = stack.pop();

                // Step 3: Check matching
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return 0;
                }
            }
        }

        // Step 4: Final check
        if (stack.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        String A = "{([{])}";
        System.out.println(EitherBalancedParenthesis(A));
    }
}