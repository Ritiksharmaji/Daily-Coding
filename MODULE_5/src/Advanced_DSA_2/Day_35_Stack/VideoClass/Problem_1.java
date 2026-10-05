package Advanced_DSA_2.Day_35_Stack.VideoClass;
/*
Q-1: implement the stack with all stack operation using array
 */
public class Problem_1 {

    int[] stack;
    int top;
    int capacity;

    // Constructor
    public Problem_1(int size) {
        capacity = size;
        stack = new int[size];
        top = -1;
    }

    // PUSH
    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        top++;
        stack[top] = x;
        System.out.println(x + " pushed");
    }

    // POP
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        int val = stack[top];
        top--;
        return val;
    }

    // PEEK
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is Empty");
            return -1;
        }
        return stack[top];
    }

    // isEmpty
    public boolean isEmpty() {
        return top == -1;
    }

    // isFull
    public boolean isFull() {
        return top == capacity - 1;
    }

    // size
    public int size() {
        return top + 1;
    }

    // display stack
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return;
        }
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }

    // MAIN METHOD
    public static void main(String[] args) {
        Problem_1 s = new Problem_1(5);

        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        System.out.println("Top element: " + s.peek());

        System.out.println("Popped: " + s.pop());

        s.display();

        System.out.println("Size: " + s.size());
    }
}
