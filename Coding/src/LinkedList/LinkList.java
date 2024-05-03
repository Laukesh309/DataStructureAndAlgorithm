package LinkedList;

public class LinkList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;
    static Node tail = null;
    static int size = 0;

    public static void addFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null && tail == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
        return;

    }

    public static void addLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null && tail == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
        return;

    }

    public static void addMiddle(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        size++;
        Node newNode = new Node(data);
        int initialPointer = 1;
        Node temp = head;
        while (initialPointer < index) {
            temp = temp.next;
            initialPointer++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return;
    }

    public static void printLinkList() {
        if (head == null && tail == null) {
            System.out.println("LinkedList is empty");
            return;
        }
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

    public static boolean isEmpty() {
        return head == null && tail == null;
    }

    public static int removeFirst() {
        if (isEmpty()) {
            System.out.println("Linked List Is Empty");
            return -1;
        }
        size--;
        int data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }

        return data;

    }

    public static int removeLast() {
        if (isEmpty()) {
            System.out.println("Linked List Is Empty");
            return -1;
        }
        size--;
        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }
        int data = tail.data;
        temp.next = null;
        tail = temp;
        return data;
    }

    public static int searchValue(int key) {
        Node temp = head;
        int initialPointer = -1;
        while (temp != null) {
            initialPointer++;
            if (temp.data == key) {
                return initialPointer;
            }
            temp = temp.next;
        }
        initialPointer = -1;
        return initialPointer;
    }

    public static int searchRecursiveWay(Node temp, int key, int index) {
        if (temp == null) {
            return -1;
        }
        if (temp.data == key) {
            return index;
        }
        return searchRecursiveWay(temp.next, key, index + 1);
    }

    public static void reverseLinkedList(Node currentNode) {
        Node prevNode = null;
        Node currNode = currentNode;
        Node nextNode = currentNode;
        while (currNode != null) {
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        head = prevNode;
    }

    public static void deleteNthNode(int n) {
        Node currentNode = head;
        Node prevNode = null;
        int nodeIndex = size - n + 1;
        for (int i = 1; i < nodeIndex; i++) {
            prevNode = currentNode;
            currentNode = currentNode.next;
        }
        prevNode.next = currentNode.next;
        return;
    }

    public static Node findMiddleNode() {
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }

    public static boolean checkLLIsPelindrome() {
        Node startNode = head;
        printLinkList();
        Node midNode = findMiddleNode();
        reverseLinkedList(midNode);
        Node lastNode = head;
        while (lastNode != null) {
            if (startNode.data != lastNode.data) {
                startNode = startNode.next;
                lastNode = lastNode.next;
            } else {
                return false;
            }

        }

        return true;

    }

    public static void main(String[] args) {

        LinkList ll = new LinkList();
        // ll.addFirst(10);
        // ll.addFirst(20);
        // ll.addLast(30);
        // ll.addFirst(40);
        // ll.addMiddle(1, 50);
        // printLinkList();
        // ll.removeFirst();
        // printLinkList();
        // ll.removeLast();
        // printLinkList();
        // ll.addFirst(60);
        // ll.addFirst(70);
        // ll.addFirst(80);
        // printLinkList();
        ll.addFirst(10);
        // ll.addFirst(20);
        // ll.addFirst(20);
        // System.out.println(searchValue(30));
        // System.out.println(searchRecursiveWay(head, 110, 0));
        // reverseLinkedList(head);
        // printLinkList();
        // deleteNthNode(3);
        // printLinkList();
        // findMiddleNode();
        System.out.println(checkLLIsPelindrome());

    }
}
