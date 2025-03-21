package LinkedListRevision;

public class findMiddleEleement {

    public static Node head;

    public static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node findMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("null");
        System.out.println();
        return;
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

    public static boolean checkPalindrom() {
        if (head == null || head.next == null) {
            return true;
        }
        Node mid = findMiddle();
        Node prev = null;
        Node curr;
        Node next;
        curr = next = mid;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node temp = head;
        Node right = prev;
        while (right != null) {
            if (temp.data != right.data) {
                return false;
            }
            right = right.next;
            temp = temp.next;
        }
        return true;
    }

    public static void main(String[] args) {
        findMiddleEleement fl = new findMiddleEleement();
        fl.addFirst(10);
        fl.addFirst(20);
        fl.addFirst(20);
        fl.addFirst(10);
        fl.printLL();
        System.out.println(fl.checkPalindrom());

    }

}
