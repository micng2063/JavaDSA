public class Stack {
    private int maxSize;
    private int top;
    private int[] stack;

    public Stack(int size){
        maxSize = size;
        stack = new int[maxSize];
        top = -1;
    }

    public boolean isFull(){
        return top == maxSize -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int value){
        if (isFull()){
            System.out.println("Stack is full, cannot push");
            return;
        }

        stack[++top] = value;
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Stack is empty, cannot pop");
            return -1;
        }

        return stack[top--];
    }

    public int peek(){
        if (isEmpty()){
            System.out.println("Stack is empty, cannot peek");
            return -1;
        }

        return stack[top];
    }
    public static void main(String[] args){
        Stack stack = new Stack(5);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Popped : " + stack.pop());
        System.out.println("Peeked : " + stack.peek());
    }
}
