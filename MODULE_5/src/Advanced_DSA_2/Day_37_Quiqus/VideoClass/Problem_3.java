package Advanced_DSA_2.Day_37_Quiqus.VideoClass;
/*
Q-3: Queue - Linked List Implementation
 */
public class Problem_3 {

    // Node class
    static class Node {
        int data;
        Node next;

        Node(int new_data) {
            data = new_data;
            next = null;
        }
    }

    Node front, rear;
    int currSize;

    // Constructor
    Problem_3() {
        front = rear = null;
        currSize = 0;
    }

    // Check if queue is empty
    boolean isEmpty() {
        return front == null;
    }

    // Enqueue (insert element)
    void enqueue(int new_data) {

        Node new_node = new Node(new_data);

        if (isEmpty()) {
            front = rear = new_node;
        } else {
            rear.next = new_node;
            rear = new_node;
        }

        currSize++;
    }

    // Dequeue (remove element)
    int dequeue() {

        if (isEmpty()) {
            System.out.println("Queue Underflow");
            return -1;
        }

        int removedData = front.data;

        front = front.next;

        if (front == null) {
            rear = null;
        }

        currSize--;

        return removedData;
    }

    // Get front element
    int getFront() {

        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return front.data;
    }

    // Get size
    int size() {
        return currSize;
    }

    // Driver Code
    public static void main(String[] args) {

        Problem_3 q = new Problem_3();

        q.enqueue(10);
        q.enqueue(20);

        System.out.println("Dequeue: " + q.dequeue());

        q.enqueue(30);

        System.out.println("Front: " + q.getFront());
        System.out.println("Size: " + q.size());
    }
}