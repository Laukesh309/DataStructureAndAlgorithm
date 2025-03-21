package LinkedListRevision;

public class DoublyLinkedList {

    public static Node head;
    public static Node tail;
    public static int size;

    public static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static void addFirst(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return;
    }

    public static void addLast(int data) {
        size++;
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
        return;
    }

    public static void printLL(Node tempHead) {

        while (tempHead != null) {
            System.out.print(tempHead.data + "->");
            tempHead = tempHead.next;

        }
        System.out.println("null");
        System.out.println();
    }

    public static void printLLReverse(Node tempHead) {

        while (tempHead != null) {
            System.out.print(tempHead.data + "->");
            tempHead = tempHead.prev;

        }
        System.out.println("null");
        System.out.println();
    }

    public static void removeFirst() {
        if (head == null) {
            System.out.println("LL is empty");
            return;
        }
        size--;
        if (size == 1) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
        return;

    }

    public static void reverLL() {
        if (head == null) {
            System.out.println("LinkedList is Empty");
            return;
        }
        Node prev = null;
        Node curr = head;
        Node next = head;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
        return;
    }

    public static void main(String[] args) {

        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addFirst(10);
        dl.addFirst(20);
        dl.addLast(30);
        printLL(head);
        reverLL();
        printLL(head);
    }

}
