package QueueTopic;

public class QueueLinkedList {

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
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            return head.data;
        }

        public static void add(int data) {
            Node node = new Node(data);
            if (isEmpty()) {
                head = tail = node;
                return;
            }
            tail.next = node;
            tail = node;
            return;

        }

        public static int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }
            int result = head.data;
            if (head == tail) {
                head = null;
                tail = null;
            } else {
                head = head.next;
            }

            return result;

        }
    }

    public static void main(String[] args) {
        Queue queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        while (!queue.isEmpty()) {
            System.out.println(queue.remove());
        }
        System.out.println(queue.isEmpty());
        queue.add(20);
        System.out.println(queue.peek());
    }

}
