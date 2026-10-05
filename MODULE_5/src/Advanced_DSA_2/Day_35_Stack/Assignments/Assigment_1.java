package Advanced_DSA_2.Day_35_Stack.Assignments;

import java.util.Stack;

public class Assigment_1 {

    public static int evaluatePostfix(String[] exp) {
        Stack<Integer> stack = new Stack<>();

        for (String ch : exp) {
            if (!ch.equals("+") && !ch.equals("-") &&
                    !ch.equals("*") && !ch.equals("/")) {

                stack.push(Integer.parseInt(ch));
            }
            else {
                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                switch (ch) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        String[] exp = {"2", "1", "+", "3", "*"};
        System.out.println(evaluatePostfix(exp));
    }
}
