package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class validateBst1 {

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

    public static boolean validateBst(Node head, Integer min, Integer max) {
        if (head == null) {
            return true;
        }
        if (head.data < min) {
            return false;
        }
        if (head.data > max) {
            return false;
        }
        return validateBst(head.left, min, head.data) && validateBst(head.right, head.data, max);
    }

    public static void formMirrorBst(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head.left;
        head.left = head.right;
        head.right = temp;
        formMirrorBst(head.left);
        formMirrorBst(head.right);
    }

    public static void main(String[] args) {

        int arr[] = { 8, 5, 3, 1, 4, 6, 10, 9, 15, 13, 16 };
        validateBst1 bst = new validateBst1();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = buildBst(root, arr[i]);
        }
        printLevelOrder(root);
        Integer min = Integer.MIN_VALUE;
        Integer max = Integer.MAX_VALUE;
        boolean isValid = validateBst(root, min, max);
        System.out.println();
        if (isValid) {
            System.out.println("Valid Bst-->");
        } else {
            System.out.println("Invalid Bst-->");
        }
        formMirrorBst(root);
        printLevelOrder(root);
    }

}
