package Advanced_DSA_2.Day_37_Quiqus.VideoClass;

import java.util.Stack;

/*
Q-4: Implement a Queue using Stack.
 */
public class Problem_4 {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        // ENQUEUE
        void enqueue(int x) {
            stack1.push(x);
        }

        // DEQUEUE
        int dequeue() {

            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue Empty");
                return -1;
            }

            // move elements only if stack2 empty
            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.pop();
        }

        // GET FRONT
        int getFront() {

            if (stack1.isEmpty() && stack2.isEmpty()) {
                System.out.println("Queue Empty");
                return -1;
            }

            if (stack2.isEmpty()) {
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            }

            return stack2.peek();
        }

        public static void main(String[] args) {

            Problem_4 q = new Problem_4();

            q.enqueue(10);
            q.enqueue(20);
            q.enqueue(30);

            System.out.println("Dequeue: " + q.dequeue());

            q.enqueue(40);

            System.out.println("Front: " + q.getFront());
        }
    }
