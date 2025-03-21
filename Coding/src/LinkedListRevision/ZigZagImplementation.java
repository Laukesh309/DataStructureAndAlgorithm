package LinkedListRevision;

public class ZigZagImplementation {

    public static Node head;

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;
    }

    public static Node getMid() {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node reverseLL(Node head) {
        Node pre = null;
        Node curr = head;
        Node next = head;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;

    }

    public static Node convertZigZag() {
        Node mid = getMid();

        Node right = mid.next;
        mid.next = null;
        Node newRightHead = reverseLL(right);
        Node tempHead = head;
        while (newRightHead != null) {
            Node leftTempHead = tempHead.next;
            tempHead.next = newRightHead;
            tempHead = leftTempHead;
            Node newTempRightNode = newRightHead.next;
            newRightHead.next = tempHead;
            newRightHead = newTempRightNode;
        }
        return head;
    }

    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.next;

        }
        System.out.print("null");
        System.out.println();
    }

    public static void main(String[] args) {
        ZigZagImplementation zz = new ZigZagImplementation();
        zz.addFirst(5);
        zz.addFirst(4);
        zz.addFirst(3);
        zz.addFirst(2);
        printLL(head);
        convertZigZag();
        printLL(head);

    }

}
