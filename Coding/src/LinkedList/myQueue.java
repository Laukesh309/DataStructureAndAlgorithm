
package LinkedList;

class Node {
    int data;
    Node next;

    Node(int new_data) {
        data = new_data;
        next = null;
    }

}

public class myQueue {
    int size;
    Node head;
    Node tail;

    public myQueue() {
        // Initialize your data members
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        // check if the queue is empty
        if (size == 0) {
            return true;
        }
        return false;
    }

    public void enqueue(int x) {
        // Adds an element x at the rear of the queue.
        Node newNode = new Node(x);
        this.size++;
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void dequeue() {
        // Removes the front element of the queue
        if (head == null) {
            return;
        }
        this.size--;
        if (size == 0) {
            head = null;
            tail = null;
            return;
        }
        head = head.next;
    }

    public int getFront() {
        // Returns the front element of the queue.
        // If queue is empty, return -1.
        if (this.size == 0) {
            return -1;
        }
        return head.data;
    }

    public int size() {
        // Returns the current size of the queue.
        return this.size;
    }

    public static void main(String[] args) {
        myQueue tempQueue = new myQueue();
        tempQueue.enqueue(8);
        tempQueue.dequeue();
        System.out.println(tempQueue.size);
        System.out.println(tempQueue.getFront());
        tempQueue.enqueue(4);
        System.out.println(tempQueue.getFront());

    }

}
