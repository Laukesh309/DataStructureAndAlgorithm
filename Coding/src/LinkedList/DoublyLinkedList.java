package LinkedList;

public class DoublyLinkedList {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    public static Node head = null;
    public static Node tail = null;
    public static int size = 0;

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        return;

    }

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null && tail == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
        return;

    }

    public static void printDLFromFirst() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void printDLFromLast() {
        Node temp = tail;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.prev;
        }
        System.out.println("Null");
    }

    public static int removeFirst() {
        if (head == null && tail == null) {
            System.out.println("LinkedList Is Empty");
            return -1;
        }
        int data = head.data;
        size--;
        if (head.next == null && tail.prev == null) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return data;
    }

    public static void reverDL() {
        Node current = head;
        Node next = head;
        Node prev = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }
        tail = head;
        head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList dl = new DoublyLinkedList();
        dl.addLast(10);
        dl.addLast(20);
        dl.addLast(30);
        dl.addFirst(40);
        printDLFromFirst();
        // printDLFromLast();
        System.out.println(size);
        removeFirst();
        printDLFromFirst();
        System.out.println(size);
        reverDL();
        printDLFromFirst();

    }

}
