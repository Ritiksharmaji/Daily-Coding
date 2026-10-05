package Advanced_DSA_2.Day_35_Stack.VideoClass;
/*
Q-1: implement the stack with all stack operation using Linkedlist
 */
public class Problem_2 {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node top; // top of stack

    // PUSH
    public void push(int x) {
        Node newNode = new Node(x);

        newNode.next = top;
        top = newNode;

        System.out.println(x + " pushed");
    }

    // POP
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }

        int val = top.data;
        top = top.next;

        return val;
    }

    // PEEK
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }

        return top.data;
    }

    // isEmpty
    public boolean isEmpty() {
        return top == null;
    }

    // DISPLAY
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }

        Node temp = top;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // MAIN
    public static void main(String[] args) {

        Problem_2 s = new Problem_2();

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Top element: " + s.peek());

        System.out.println("Popped: " + s.pop());

        s.display();
    }
}
