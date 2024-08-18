public class LinkedList {
    static class Node{
        int data;
        Node next;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void traverse(Node head){
        Node current = head;

        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
    }

    private int size = 0;

    public boolean search(Node head, int target){
        Node current = head;

        while (current != null){
            if (current.data == target){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int findLength(Node head){
        Node current = head;

        int listLength = 0;
        while(current != null){
            listLength++;
            current = current.next;
        }

        return listLength;
    }

    public Node insertAtHead(Node head, int value){
        Node newNode = new Node(value);
        newNode.next = head;
        return newNode;
    }

    public void insertAtEnd(Node head, int value){
        Node newNode = new Node(value);

        if (head == null){
            head = newNode;
            return;
        }

        Node current = head;

        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public void insert(Node head, int target, int position){
        Node newNode = new Node(target);

        if (position < 1 || position > findLength(head) + 1){
            System.out.println("Invalid position to insert new node");
            return;
        }

        if (position == 1){
            newNode.next = head;
            head = newNode;
        }
        else {
            Node current = head;
            for (int i = 0; i < position - 1; i++){
                if (current == null){
                    System.out.println("Out of bound position to insert new node");
                    return;
                }
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }

    public Node removeHead(Node head){
        if (head == null) {
            return null;
        }

        return head.next;
    }

    public Node removeEnd(Node head){
        if (head == null || head.next == null){
            return null;
        }

        Node current = head;
        while (current.next.next != null){
            current = current.next;
        }

        current.next = null;
        return head;
    }

    public void remove(Node head, int position){
        if (head == null || position < 1){
            return;
        }

        if (position == 0){
            head = head.next;
            return;
        }

        Node current = head;
        for (int i = 0; i < position - 1 && current != null; i++){
            current = current.next;
        }

        if (current == null || current.next == null){
            return;
        }

        current.next = current.next.next;

    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();

        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(40);

        head.next = second;
        second.next = third;

        System.out.print("Traverse: ");
        list.traverse(head);
        System.out.println();

        System.out.println("Search for 20: " + list.search(head, 20) );
        System.out.println("Search for 30: " + list.search(head, 30) );

        System.out.println("List size: " + list.findLength(head));

        head = list.insertAtHead(head, 5);
        System.out.print("After insert (5) at beginning: ");
        list.traverse(head);
        System.out.println();

        list.insertAtEnd(head, 50);
        System.out.print("After insert (50) at end: ");
        list.traverse(head);
        System.out.println();

        list.insert(head, 30, 3);
        System.out.print("After insert (30) at position 3: ");
        list.traverse(head);
        System.out.println();

        head = list.removeHead(head);
        System.out.print("After removing head node (5): ");
        list.traverse(head);
        System.out.println();

        head = list.removeEnd(head);
        System.out.print("After removing last node (50): ");
        list.traverse(head);
        System.out.println();

        list.remove(head, 3);
        System.out.print("After removing node at position 3: ");
        list.traverse(head);
        System.out.println();

    }

}
