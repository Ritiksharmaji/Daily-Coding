package Advanced_DSA_2.Day_37_Quiqus.VideoClass;

/*
 Q-1: Queue using Array - Simple Implementation
*/

public class Problem_1 {

    int capacity;
    int[] arr;
    int size;

    // Constructor
    Problem_1(int capacity) {

        // Maximum number of elements the queue can hold
        this.capacity = capacity;

        // Array to store queue elements
        this.arr = new int[capacity];

        // Current number of elements in queue
        this.size = 0;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return this.size == 0;
    }

    // Check if queue is full
    boolean isFull() {
        return this.size == this.capacity;
    }

    // Enqueue (Insert element)
    void enqueue(int x) {

        if (this.isFull()) {
            System.out.println("Queue is full!");
            return;
        }

        this.arr[this.size] = x;
        this.size++;
    }

    // Dequeue (Remove element)
    void dequeue() {

        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        for (int i = 1; i < this.size; i++) {
            this.arr[i - 1] = this.arr[i];
        }

        this.size--;
    }

    // Get front element
    int getFront() {

        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return this.arr[0];
    }

    // Get rear element
    int getRear() {

        if (this.isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }

        return this.arr[this.size - 1];
    }

    // Driver Code
    public static void main(String[] args) {

        Problem_1 q = new Problem_1(3);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front: " + q.getFront());

        q.dequeue();

        System.out.println("Front: " + q.getFront());
        System.out.println("Rear: " + q.getRear());

        q.enqueue(40);
    }
}