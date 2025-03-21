package LinkedListRevision;

public class palindromicList {

    static Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static void addFirst(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;
    }

    public static Node getMiddle(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        palindromicList pl = new palindromicList();
        pl.addFirst(1);
        pl.addFirst(2);
        pl.addFirst(2);
        pl.addFirst(1);
        Node middleNode = getMiddle(head);
        Node secondNode = middleNode.next;
        middleNode.next = null;
        Node prev = middleNode;
        Node curNode = secondNode;
        Node nextNode = secondNode;
        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = prev;
            prev = curNode;
            curNode = nextNode;
        }
        secondNode = prev;
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;

        }
    }

}
