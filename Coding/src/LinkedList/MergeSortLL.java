package LinkedList;

import DivideAndConquar.mergeSort;

public class MergeSortLL {

    static class Node {
        int data;
        Node next;
        public static Node head = null;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static class LL {
        public static Node head;

        public static void Add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
            return;
        }

        public static void printLL(Node currentNode) {
            Node temp = currentNode;
            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("Null");
        }

        public static Node mergeTwoLinkedList(Node leftNode, Node rightNode) {
            Node tempHead = new Node(-1);
            Node currentHead = tempHead;
            while (leftNode != null && rightNode != null) {
                if (leftNode.data < rightNode.data) {
                    currentHead.next = leftNode;
                    currentHead = leftNode;
                    leftNode = leftNode.next;
                } else {
                    currentHead.next = rightNode;
                    currentHead = rightNode;
                    rightNode = rightNode.next;
                }

            }
            if (leftNode == null) {
                currentHead.next = rightNode;
            }
            if (rightNode == null) {
                currentHead.next = leftNode;
            }
            leftNode = tempHead.next;
            return leftNode;

        }

        public static Node mergeSort(Node initialNode) {
            if (initialNode == null || initialNode.next == null) {
                return initialNode;
            }
            Node slow = initialNode;
            Node fast = initialNode.next;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            Node rightHead = slow.next;
            slow.next = null;
            // System.out.println(rightHead.data);
            Node leftMerge = mergeSort(initialNode);
            Node rightMerge = mergeSort(rightHead);
            // System.out.println();
            return mergeTwoLinkedList(leftMerge, rightMerge);

        }

    }

    public static void main(String[] args) {
        LL ll = new LL();
        ll.Add(30);
        ll.Add(40);
        ll.Add(50);
        ll.Add(60);
        ll.printLL(ll.head);
        Node temp = ll.mergeSort(ll.head);
        ll.printLL(temp);

    }

}
