package LinkedList;

public class MiddleOfLinkedList {
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    int getMiddle(Node head) {
        // code here
        Node tempNode = head;
        Node firstPointer = head;
        Node secondPointer = head;
        while (secondPointer != null && secondPointer.next != null) {
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next.next;
        }
        return firstPointer.data;

    }
}
