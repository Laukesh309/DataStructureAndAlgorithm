package tree;

import java.util.LinkedList;
import java.util.Queue;

public class preorderBuild {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    int currentIndex = -1;

    public Node buildPreOrder(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[currentIndex]);
        newNode.prev = buildPreOrder(arr);
        newNode.next = buildPreOrder(arr);
        return newNode;
    }

    public static void preOrderTraversal(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        preOrderTraversal(head.prev);
        preOrderTraversal(head.next);
    }

    public static void inOrderTraversal(Node head) {
        if (head == null) {
            return;
        }
        inOrderTraversal(head.prev);
        System.out.println(head.data);
        inOrderTraversal(head.next);
    }

    public static void postOrderTraversal(Node head) {
        if (head == null) {
            return;
        }
        postOrderTraversal(head.prev);
        postOrderTraversal(head.next);
        System.out.println(head.data);
    }

    public static void levelOrderTraversal(Node head) {
        Queue<Node> que = new LinkedList<>();
        que.add(head);
        que.add(null);
        while (!que.isEmpty()) {
            Node tempNode = que.remove();
            if (tempNode == null) {
                if (que.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                    que.add(null);
                }
            } else {
                System.out.print(tempNode.data + " ");
                if (tempNode.prev != null) {
                    que.add(tempNode.prev);
                }
                if (tempNode.next != null) {
                    que.add(tempNode.next);
                }
            }
        }
    }

    public static int maxHeight(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + Math.max(maxHeight(head.prev), maxHeight(head.next));
    }

    public static int countOfNode(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + countOfNode(head.prev) + countOfNode(head.next);
    }

    public static int sumOfNode(Node head) {
        if (head == null) {
            return 0;
        }
        return head.data + sumOfNode(head.prev) + sumOfNode(head.next);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1 };
        preorderBuild p1 = new preorderBuild();
        Node root = p1.buildPreOrder(arr);
        // preOrderTraversal(root);
        // inOrderTraversal(root);
        // postOrderTraversal(root);
        // levelOrderTraversal(root);
        System.out.println(maxHeight(root));
        System.out.println(countOfNode(root));
        System.out.println(sumOfNode(root));

    }

}
