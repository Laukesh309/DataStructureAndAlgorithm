package LinkedList;

public class CycleDetectInLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static boolean isCycleInLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;

    }

    public static void removeCycle(Node head) {
        boolean isCycle = isCycleInLinkedList(head);
        if (!isCycle) {
            System.out.println("there is no cycle exiit");
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next == head) {
                temp.next = null;
            }
            temp = temp.next;
        }
        return;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("Null");
    }

    public static void main(String[] args) {
        Node head = new Node(20);
        head.next = new Node(30);
        head.next.next = new Node(40);
        head.next.next.next = new Node(50);
        // head.next.next.next = head;
        // printLinkedList(head);
        // System.out.println(isCycleInLinkedList(head));
        removeCycle(head);
        printLinkedList(head);

    }

}
