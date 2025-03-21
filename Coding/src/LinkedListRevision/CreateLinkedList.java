package LinkedListRevision;

import top150InterviewProblem.DPProblem.easy.happyNum;

public class CreateLinkedList {
    public static Node head;
    public static Node tail;
    public static int size;

    public static class Node {
        int data;
        Node next;
        static int size;

        Node(int data) {
            this.data = data;
            this.next = null;
            size++;
        }

        public static int getSize() {
            return size;
        }
    }

    public static void add(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;

    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        return;
    }

    public static void printLinkedList() {

        if (head == null) {
            System.out.println("Linked List Is Empty");
            return;
        }
        Node tempHead = head;
        while (tempHead != null) {
            System.out.print(tempHead.data + "->");
            tempHead = tempHead.next;
        }
        System.out.print("null");
        System.out.println();
    }

    public static void addMiddle(int index, int data) {
        if (index == 0) {
            add(data);
            return;
        }
        int i = 0;
        size++;
        Node temp = head;
        while (i < index - 1) {
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;
        return;

    }

    public static int removeLast() {
        if (size == 0) {
            System.out.println("LL is Empty");
            return Integer.MIN_VALUE;
        }
        size--;
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int val = tail.data;
        temp.next = null;
        tail = temp;
        return val;

    }

    public static int removeFirst() {
        if (size == 0) {
            System.out.println("LinkedList Is Empty");
            return Integer.MIN_VALUE;
        }
        size--;
        if (size == 1) {
            int val = head.data;
            head = tail = null;

            return val;
        }
        Node currentNode = head;
        head = head.next;
        return currentNode.data;

    }

    public static int findKey(int key, Node currentNode, int index) {
        if (currentNode == null) {
            return -1;
        }
        if (currentNode.data == key) {
            return index;
        }
        return findKey(key, currentNode.next, index + 1);

    }

    public static void reverseLinkedList(Node currentNode, Node prevNode) {
        if (currentNode.next == null) {
            currentNode.next = prevNode;
            head = currentNode;
            return;
        }
        reverseLinkedList(currentNode.next, currentNode);
        currentNode.next = prevNode;
    }

    public static void reverseLinkedListIterative() {
        Node prev = null;
        Node current;
        Node next;
        current = next = head;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

    }

    public static void main(String[] args) {
        CreateLinkedList ll = new CreateLinkedList();
        ll.add(10);
        ll.add(20);
        ll.add(30);
        ll.addMiddle(3, 40);

        ll.printLinkedList();
        // ll.reverseLinkedList(head, null);
        ll.reverseLinkedListIterative();
        ll.printLinkedList();
        // System.out.println(size);
        // System.out.println(findKey(10, head, 0));

    }

}
