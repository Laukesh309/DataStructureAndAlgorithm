package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class buildBinaryTreeCode {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printLevelOrder(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node tempNode = queue.remove();
            if (tempNode == null && queue.isEmpty()) {
                break;
            }
            if (tempNode == null) {
                System.out.println();
                queue.add(null);
            } else {
                System.out.print(tempNode.data + " ");
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }
    }

    public static Node buildBst(Node head, int data) {
        if (head == null) {
            Node newNode = new Node(data);
            return newNode;
        }
        if (data < head.data) {
            head.left = buildBst(head.left, data);
        }
        if (data > head.data) {
            head.right = buildBst(head.right, data);
        }
        return head;
    }

    public static void main(String[] args) {

        int arr[] = { 8, 5, 3, 1, 4, 6, 10, 9, 15, 13, 16 };
        validateBst1 bst = new validateBst1();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = buildBst(root, arr[i]);
        }
        printLevelOrder(root);
    }

}
