package LinkedList;

public class ZigZagLL {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LL {
        public static Node head = null;

        public static void printLL() {
            Node temp = head;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println();
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
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

        public static Node reverseRightHead(Node rightHead) {
            Node prev = null;
            Node curr = rightHead;
            Node next = rightHead;
            while (curr != null) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

            }

            return prev;

        }

        public static void getZigZagList(Node rightHead) {
            Node rightNode = reverseRightHead(rightHead);
            Node temp = new Node(-1);
            Node leftNode = head;
            while (rightNode != null) {
                temp.next = leftNode;
                leftNode = leftNode.next;
                temp = temp.next;
                temp.next = rightNode;
                rightNode = rightNode.next;
                temp = temp.next;

            }
            if (leftNode != null) {
                temp.next = leftNode;
            }

        }

        public static void findZigZag() {
            Node getMid = getMid();
            Node rightHead = getMid.next;
            getMid.next = null;
            getZigZagList(rightHead);

        }
    }

    public static void main(String[] args) {

        LL ll = new LL();
        ll.add(5);
        ll.add(4);
        ll.add(3);
        ll.add(2);
        ll.add(1);

        ll.printLL();
        ll.findZigZag();
        ll.printLL();

    }

}
