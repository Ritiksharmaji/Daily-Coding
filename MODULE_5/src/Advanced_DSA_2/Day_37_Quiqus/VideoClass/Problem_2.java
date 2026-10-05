package Advanced_DSA_2.Day_37_Quiqus.VideoClass;

/*
Q-2: Implementation of Circular Queue Using Array
*/

public class Problem_2 {

    int[] arr;
    int front;
    int size;
    int capacity;

    // Constructor
    Problem_2(int cap) {

        arr = new int[cap];
        front = 0;
        size = 0;
        capacity = cap;
    }

    // Insert element
    void enqueue(int x) {

        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }

        int rear = (front + size) % capacity;

        arr[rear] = x;

        size++;
    }

    // Remove element
    int dequeue() {

        if (size == 0) {
            System.out.println("Queue is empty!");
            return -1;
        }

        int res = arr[front];

        front = (front + 1) % capacity;

        size--;

        return res;
    }

    // Get Front
    int getFront() {

        if (size == 0)
            return -1;

        return arr[front];
    }

    // Get Rear
    int getRear() {

        if (size == 0)
            return -1;

        int rear = (front + size - 1) % capacity;

        return arr[rear];
    }

    // Driver Code
    public static void main(String[] args) {

        Problem_2 q = new Problem_2(5);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.getFront() + " " + q.getRear());

        q.dequeue();

        System.out.println(q.getFront() + " " + q.getRear());

        q.enqueue(40);

        System.out.println(q.getFront() + " " + q.getRear());
    }
}