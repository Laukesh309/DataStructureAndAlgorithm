package LinkedListRevision;

public class mergeSort {

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

    public static Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node MergeSort(Node left, Node right) {
        Node tempHead = new Node(-1);
        Node currentTemp = tempHead;
        while (left != null && right != null) {
            if (left.data <= right.data) {
                currentTemp.next = left;
                left = left.next;
            } else {
                currentTemp.next = right;
                right = right.next;
            }
            currentTemp = currentTemp.next;
        }
        while (left != null) {
            currentTemp.next = left;
            left = left.next;
            currentTemp = currentTemp.next;
        }
        while (right != null) {
            currentTemp.next = right;
            right = right.next;
            currentTemp = currentTemp.next;
        }
        return tempHead.next;
    }

    public static Node merge(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node mid = getMid(head);
        Node right = mid.next;
        mid.next = null;
        Node newLeft = merge(head);
        Node newRight = merge(right);
        return MergeSort(newLeft, newRight);

    }

    public static void printLL(Node head) {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + "->");
            currentNode = currentNode.next;

        }
        System.out.println("null");
        System.out.println();
    }

    public static void main(String[] args) {
        mergeSort ms = new mergeSort();
        ms.addFirst(1);
        ms.addFirst(2);
        ms.addFirst(3);
        ms.addFirst(4);
        ms.printLL(head);
        Node mergeList = merge(head);
        ms.printLL(mergeList);
    }

}
