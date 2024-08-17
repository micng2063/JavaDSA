import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    // Node class representing a single node in the binary tree
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    // Constructor to initialize the root of the tree
    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node with a given key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in the binary search tree
    private Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to print the tree in in-order (DFS)
    public void inorder() {
        inorderRec(root);
    }

    // A utility function to do in-order traversal of BST
    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left); // Traverse the left subtree
            System.out.print(root.key + " "); // Print the root node
            inorderRec(root.right); // Traverse the right subtree
        }
    }

    // Method to print the tree in pre-order (DFS)
    public void preorder() {
        preorderRec(root);
    }

    // A utility function to do pre-order traversal of BST
    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " "); // Print the root node
            preorderRec(root.left); // Traverse the left subtree
            preorderRec(root.right); // Traverse the right subtree
        }
    }

    // Method to print the tree in post-order (DFS)
    public void postorder() {
        postorderRec(root);
    }

    // A utility function to do post-order traversal of BST
    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left); // Traverse the left subtree
            postorderRec(root.right); // Traverse the right subtree
            System.out.print(root.key + " "); // Print the root node
        }
    }

    // Method to print the tree in level-order (BFS)
    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll(); // Remove the node from the front of the queue
            System.out.print(current.key + " "); // Print the node's key

            // Add left and right children to the queue
            if (current.left != null) {
                queue.add(current.left);
            }

            if (current.right != null) {
                queue.add(current.right);
            }
        }
    }

    // Method to search for a key in the tree
    public boolean search(int key) {
        return searchRec(root, key);
    }

    // A utility function to search for a key in BST
    private boolean searchRec(Node root, int key) {
        if (root == null) {
            return false; // Key not found
        }

        if (root.key == key) {
            return true; // Key found
        }

        if (key < root.key) {
            return searchRec(root.left, key); // Search in the left subtree
        } else {
            return searchRec(root.right, key); // Search in the right subtree
        }
    }

    // Method to find the minimum value in the tree
    public int findMin() {
        return findMinRec(root);
    }

    // A utility function to find the minimum value in BST
    private int findMinRec(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty"); // Handle empty tree
        }

        if (root.left == null) {
            return root.key; // Minimum value is the leftmost node
        }

        return findMinRec(root.left); // Recur down the left subtree
    }

    // Method to find the maximum value in the tree
    public int findMax() {
        return findMaxRec(root);
    }

    // A utility function to find the maximum value in BST
    private int findMaxRec(Node root) {
        if (root == null) {
            throw new IllegalStateException("Tree is empty"); // Handle empty tree
        }

        if (root.right == null) {
            return root.key; // Maximum value is the rightmost node
        }

        return findMaxRec(root.right); // Recur down the right subtree
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert some nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the tree
        System.out.println("Inorder traversal:");
        tree.inorder(); // Output: 20 30 40 50 60 70 80
        System.out.println();

        // Print preorder traversal of the tree
        System.out.println("Preorder traversal:");
        tree.preorder(); // Output: 50 30 20 40 70 60 80
        System.out.println();

        // Print postorder traversal of the tree
        System.out.println("Postorder traversal:");
        tree.postorder(); // Output: 20 40 30 60 80 70 50
        System.out.println();

        // Print level-order traversal of the tree
        System.out.println("Level-order traversal:");
        tree.levelOrder(); // Output: 50 30 70 20 40 60 80
        System.out.println();

        // Search for a key
        int searchKey = 40;
        if (tree.search(searchKey)) {
            System.out.println("Key " + searchKey + " found in the tree.");
        } else {
            System.out.println("Key " + searchKey + " not found in the tree.");
        }

        // Find minimum and maximum values
        System.out.println("Minimum value in the tree: " + tree.findMin());
        System.out.println("Maximum value in the tree: " + tree.findMax());
    }
}
