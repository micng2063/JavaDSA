public class Stack {
    private int maxSize; // Maximum size of the stack
    private int top;     // Index of the top element
    private int[] stack; // Array to hold stack elements

    // Constructor to initialize the stack with a given size
    public Stack(int size) {
        maxSize = size;
        stack = new int[maxSize];
        top = -1; // Indicates the stack is empty
    }

    // Method to add an element to the stack
    public void push(int value) {
        if (isFull()) {
            System.out.println("Stack is full. Cannot push " + value);
            return;
        }
        stack[++top] = value;
        System.out.println("Pushed " + value);
    }

    // Method to remove and return the top element from the stack
    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Cannot pop");
            return -1; // Indicating an error condition
        }
        return stack[top--];
    }

    // Method to get the top element of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty. Nothing to peek");
            return -1; // Indicating an error condition
        }
        return stack[top];
    }

    // Method to check if the stack is full
    public boolean isFull() {
        return top == maxSize - 1;
    }

    // Method to check if the stack is empty
    public boolean isEmpty() {
        return top == -1;
    }

    // Main method to test stack operations
    public static void main(String[] args) {
        Stack stack = new Stack(5); // Create a stack with capacity 5

        // Test stack operations
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60); // Should indicate that the stack is full

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());
        System.out.println("Popped element: " + stack.pop());

        System.out.println("Top element is: " + stack.peek());

        System.out.println("Stack empty: " + stack.isEmpty());
        System.out.println("Stack full: " + stack.isFull());
    }
}
