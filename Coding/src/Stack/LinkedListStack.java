package Stack;

public class LinkedListStack {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        static Node head = null;

        // check empty comdition
        public static boolean isEmpty() {
            return head == null;
        }

        // push operation for stack
        public static void push(int data) {
            Node node = new Node(data);
            node.next = head;
            head = node;
        }

        // pop Operation for stack
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int data = head.data;
            head = head.next;
            return data;
        }

        // find peek element
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        while (!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
        System.out.println(stack.isEmpty());
    }

}
