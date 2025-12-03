package LinkedList;

public class deleteMiddleOfNode {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head;

    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return;

    }

    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "=>");
            temp = temp.next;

        }
        return;
    }

    public Node deleteMiddle() {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = null;
        Node cur = head;
        Node nextPointer = head;
        while (nextPointer != null && nextPointer.next != null) {
            prev = cur;
            cur = cur.next;
            nextPointer = nextPointer.next.next;
        }
        prev.next = cur.next;
        cur.next = null;
        return head;

    }

    public static void main(String[] args) {
        deleteMiddleOfNode dl = new deleteMiddleOfNode();
        dl.insert(1);
        dl.insert(2);
        dl.insert(3);
        dl.insert(4);
        dl.insert(5);
        dl.printLinkedList();

    }

}
