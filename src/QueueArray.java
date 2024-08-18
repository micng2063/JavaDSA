public class QueueArray {
    static class Queue{
        int front, rear, size, capacity;
        int[] queue;

        Queue(int c){
            front = 0;
            rear = -1;
            size = 0;
            capacity = c;
            queue = new int[capacity];
        }

        public void enqueue(int data) {
            if (size == capacity) {
                System.out.println("Queue is full");
                return;
            }

            rear = (rear + 1) % capacity;
            queue[rear] = data;
            size++;
        }

        public void dequeue() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }

            front = (front + 1) % capacity;
            size--;
        }

        public void display() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }

            for (int i = 0; i < size; i++) {
                System.out.print(queue[(front + i) % capacity] + " ");
            }
            System.out.println();
        }

        public void printFront() {
            if (size == 0) {
                System.out.println("Queue is empty");
                return;
            }

            System.out.println("Front element in queue: " + queue[front]);
        }
    }

    public static void main(String[] args){
        Queue q = new Queue(4);

        q.enqueue(1);
        q.enqueue(5);
        q.enqueue(6);

        System.out.print("Display queue after inserting 1, 5, 6: ");
        q.display();
        System.out.println();

        q.dequeue();

        System.out.print("Display queue after dequeuing: ");
        q.display();
        System.out.println();

        q.printFront();
    }
}
