import java.util.*;

public class QueueArray {

    // Static inner class representing a queue
    static class Queue {
        int front, rear, size, capacity;
        int[] queue;

        // Constructor to initialize the queue
        Queue(int c) {
            front = 0;
            rear = -1;
            size = 0;
            capacity = c;
            queue = new int[capacity];
        }

        // Function to insert an element at the rear of the queue
        void enqueue(int data) {
            if (size == capacity) {
                System.out.println("Queue is full");
                return;
            }

            // Increment rear and add the element
            rear = (rear + 1) % capacity;
            queue[rear] = data;
            size++;
        }

        // Function to delete an element from the front of the queue
        void dequeue() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }

            // Increment front
            front = (front + 1) % capacity;
            size--;
        }

        // Function to print queue elements
        void display() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return;
            }

            // Traverse from front to rear
            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % capacity] + " ");
            }
            System.out.println();
        }

        // Function to print the front of the queue
        void printFront() {
            if (size == 0) {
                System.out.println("Queue is Empty");
                return;
            }
            System.out.println("Front Element is: " + queue[front]);
        }
    }

    // Main method to test the Queue implementation
    public static void main(String[] args) {
        // Create a queue of capacity 4
        Queue q = new Queue(4);

        // Print queue elements
        q.display();

        // Insert elements in the queue
        q.enqueue(20);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        // Print queue elements
        q.display();

        // Try inserting an element when queue is full
        q.enqueue(60);

        // Print queue elements
        q.display();

        // Dequeue elements
        q.dequeue();
        q.dequeue();

        System.out.println("After two deletions");

        // Print queue elements
        q.display();

        System.out.println("After one insertion");
        q.enqueue(60);

        // Print queue elements
        q.display();

        // Print front of the queue
        q.printFront();
    }
}
