class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    // This will be used in the insertPos method for size checking
    private int size = 0;

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Initialize nodes
        Node head = new Node(10);
        Node second = new Node(20);
        Node third = new Node(30);

        // Link nodes
        head.next = second;
        second.next = third;

        System.out.print("Original List: ");
        list.traverse(head);

        head = list.insertAtBeginning(head, 5);
        System.out.print("After inserting at beginning: ");
        list.traverse(head);

        list.insertAtEnd(head, 40);
        System.out.print("After inserting at end: ");
        list.traverse(head);

        list.insertPos(head, 3, 25);
        System.out.print("After inserting at position 3: ");
        list.traverse(head);

        System.out.print("Search for 25: " + list.search(head, 25) + "\n");
        System.out.print("Search for 100: " + list.search(head, 100) + "\n");

        System.out.print("Length of the list: " + list.findLength(head) + "\n");

        head = list.removeFirstNode(head);
        System.out.print("After removing the first node: ");
        list.traverse(head);

        head = list.removeLastNode(head);
        System.out.print("After removing the last node: ");
        list.traverse(head);

        list.deleteAtPosition(head, 2);
        System.out.print("After deleting node at position 2: ");
        list.traverse(head);
    }

    // Method to traverse and print all nodes in the list
    public void traverse(Node head) {
        Node current = head;
        // Traverse the linked list
        while (current != null) {
            // Print the data of the current node
            System.out.print(current.data + " ");
            // Move to the next node
            current = current.next;
        }
        // Move to the next line after printing all nodes
        System.out.println();
    }

    // Method to search for a target value in the list
    public boolean search(Node head, int target) {
        Node current = head;
        // Traverse the linked list
        while (current != null) {
            // Check if the current node's data matches the target
            if (current.data == target) {
                return true; // Value found
            }
            // Move to the next node
            current = current.next;
        }
        return false; // Value not found
    }

    // Method to find the length of the linked list
    public int findLength(Node head) {
        int length = 0;
        Node current = head;
        // Traverse the linked list
        while (current != null) {
            length++; // Increment length for each node
            // Move to the next node
            current = current.next;
        }
        return length; // Return the total length
    }

    // Method to insert a new node at the beginning of the list
    public Node insertAtBeginning(Node head, int value) {
        Node newNode = new Node(value);
        // Set the new node's next to the current head
        newNode.next = head;
        // New node becomes the new head
        return newNode;
    }

    // Method to insert a new node at the end of the list
    public void insertAtEnd(Node head, int value) {
        Node newNode = new Node(value);
        // If the list is empty, set the new node as the head
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        // Traverse to the end of the list
        while (current.next != null) {
            current = current.next;
        }
        // Link the new node to the end of the list
        current.next = newNode;
    }

    // Method to insert a new node at a specific position
    public void insertPos(Node head, int pos, int data) {
        // Check if the position is valid
        if (pos < 1 || pos > findLength(head) + 1) { // Use findLength to get the correct size
            System.out.println("Invalid position!");
            return;
        }
        Node newNode = new Node(data);
        // If inserting at the beginning
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            // Traverse to the node just before the position
            for (int i = 1; i < pos - 1; i++) {
                if (current == null) {
                    System.out.println("Position out of bounds");
                    return;
                }
                current = current.next;
            }
            // Insert the new node at the desired position
            newNode.next = current.next;
            current.next = newNode;
        }
    }

    // Method to remove the first node of the list
    public Node removeFirstNode(Node head) {
        if (head == null) return null; // Return null if list is empty
        // Move head to the next node
        return head.next;
    }

    // Method to remove the last node of the list
    public Node removeLastNode(Node head) {
        if (head == null) return null; // Return null if list is empty
        if (head.next == null) return null; // Return null if list has only one node
        Node second_last = head;
        // Traverse to the second last node
        while (second_last.next.next != null) {
            second_last = second_last.next;
        }
        // Remove the last node
        second_last.next = null;
        return head;
    }

    // Method to delete a node at a specific position
    public void deleteAtPosition(Node head, int position) {
        // If the list is empty or position is invalid
        if (head == null || position < 1) return;
        // If deleting the head node
        if (position == 1) {
            head = head.next;
            return;
        }
        Node current = head;
        // Traverse to the node just before the position
        for (int i = 1; i < position - 1 && current != null; i++) {
            current = current.next;
        }
        // If position is out of bounds
        if (current == null || current.next == null) return;
        // Bypass the node to be deleted
        current.next = current.next.next;
    }
}
