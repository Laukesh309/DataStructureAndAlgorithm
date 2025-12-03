package LinkedList;

// Node class
class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }
}

public class myStack {
    int currentSize;
    Node head;

    public myStack() {
        // Initialize your data members
        this.head = null;
        this.currentSize = 0;
    }

    public boolean isEmpty() {
        // check if the stack is empty
        if (currentSize == 0) {
            return true;
        }
        return false;

    }

    public void push(int x) {
        // Adds an element x at the rear of the stack.
        this.currentSize++;
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void pop() {
        // Removes the front element of the stack.
        if (head == null) {
            return;
        }
        head = head.next;
        this.currentSize--;
    }

    public int peek() {
        // Returns the front element of the stack.
        // If stack is empty, return -1.
        if (head == null) {
            return -1;
        }
        return head.data;
    }

    public int size() {
        // Returns the current size of the stack.
        return currentSize;
    }

    public static void main(String[] args) {

    }

}
