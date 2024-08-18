public class QueueLinkedList {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    static class Queue{
        Node front, rear;

        Queue(){
            front = rear = null;
        }

        public boolean isEmpty(){
            return front == null;
        }

        public void enqueue(int data){
            Node newNode = new Node(data);

            if (rear == null){
                front = rear = newNode;
                return;
            }

            rear.next = newNode;
            rear = newNode;
        }

        public void dequeue(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return;
            }

            front = front.next;

            if (front == null){
                rear = null;
            }
        }

        public void display() {
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return;
            }

            Node current = front;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }

        public int getFront(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MIN_VALUE;
            }

            return front.data;
        }

        public int getRear(){
            if (isEmpty()){
                System.out.println("Queue is empty");
                return Integer.MAX_VALUE;
            }

            return rear.data;
        }
    }

    public static void main(String[] args){
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(30);
        q.enqueue(20);

        q.display();

        q.dequeue();

        q.display();

        System.out.println("Front: " + q.getFront());
        System.out.println("Rear: " + q.getRear());
    }
}
