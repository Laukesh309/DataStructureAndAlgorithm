package QueueTopic;

import java.util.LinkedList;

public class QueueLinkedList1 {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node rear = null;

        public static boolean isEmpty() {
            return head == null && rear == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                rear = newNode;
                return;
            }
            rear.next = newNode;
            rear = newNode;
            return;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
            }
            return head.data;
        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            int data = head.data;
            if (head == rear) {
                head = rear = null;
            } else {
                head = head.next;
            }
            return data;
        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());

        }
        ;
    }

}
