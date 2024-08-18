import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    static class Node{
        int key;
        Node left, right;

        public Node(int data){
            key = data;
            left = right = null;
        }
    }

    Node root;
    public BinaryTree(){
        root = null;
    }

    public void insert(int key){
        root = insertNode(root, key);
    }

    private Node insertNode(Node root, int key){
        if (root == null){
            root  = new Node(key);
            return root;
        }

        if (key < root.key){
            root.left = insertNode(root.left, key);
        }
        else{
            root.right = insertNode(root.right, key);
        }
        return root;
    }

    public void inOrder(){
        inOrderTraverse(root);
    }

    private void inOrderTraverse(Node root){
        if (root != null){
            inOrderTraverse(root.left);
            System.out.print(root.key + " ");
            inOrderTraverse(root.right);
        }
    }

    public void preOrder(){
        preOrderTraverse(root);
    }

    public void preOrderTraverse(Node root){
        if (root != null){
            System.out.print(root.key + " ");
            inOrderTraverse(root.left);
            inOrderTraverse(root.right);
        }
    }

    public void postOrder(){
        postOrderTraverse(root);
    }

    public void postOrderTraverse(Node root){
        if (root != null){
            inOrderTraverse(root.left);
            inOrderTraverse(root.right);
            System.out.print(root.key + " ");
        }
    }

    public void levelOrder(){
        if (root == null){
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.poll(); // remove node from front of queue
            System.out.print(current.key + " ");

            if (current.left != null){
                queue.add(current.left);
            }

            if (current.right != null){
                queue.add(current.right);
            }
        }
    }

    public boolean search(int key){
        return searchTraverse(root, key);
    }

    private boolean searchTraverse(Node root, int key){
        if (root == null){
            return false;
        }

        if (root.key == key){
            return true;
        }

        if (key < root.key){
            return searchTraverse(root.left, key);
        }
        else {
            return searchTraverse(root.right, key);
        }
    }

    public int findMin(){
        return findMinTraverse(root);
    }

    public int findMinTraverse(Node root){
        if (root == null){
            throw new IllegalStateException("Tree is empty");
        }

        if (root.left == null){
            return root.key;
        }

        return findMinTraverse(root.left);
    }

    public int findMax(){
        return findMaxTraverse(root);
    }

    public int findMaxTraverse(Node root){
        if (root == null){
            throw new IllegalStateException("Tree is empty");
        }

        if (root.right == null){
            return root.key;
        }

        return findMaxTraverse(root.right);
    }

    public static void main(String[] args){
        BinaryTree tree = new BinaryTree();

        tree.insert(20);
        tree.insert(10);
        tree.insert(50);
        tree.insert(30);
        tree.insert(40);

        System.out.print("In order traverse: ");
        tree.inOrder();
        System.out.println();

        System.out.print("Pre order traverse: ");
        tree.preOrder();
        System.out.println();

        System.out.print("Post order traverse: ");
        tree.postOrder();
        System.out.println();

        System.out.print("Level order traverse: ");
        tree.levelOrder();
        System.out.println();

        System.out.println("Search for (20): " + tree.search(20));
        System.out.println("Search for (15): " + tree.search(15));

        System.out.println("Search for min: " + tree.findMin());
        System.out.println("Search for max: " + tree.findMax());
    }
}
