package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class convertBst {

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

    public static Node buildBst(Node head, int data) {
        if (head == null) {
            Node newNode = new Node(data);
            return newNode;
        }
        if (head.data < data) {
            head.right = buildBst(head.right, data);
        }
        if (head.data > data) {
            head.left = buildBst(head.left, data);
        }
        return head;
    }

    public static void printpreOrderBst(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + "->");
        printpreOrderBst(head.left);
        printpreOrderBst(head.right);
        return;
    }

    public static void inOrderTraversal(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        inOrderTraversal(head.left, arr);
        arr.add(head);
        inOrderTraversal(head.right, arr);

    }

    public static void printArrayList(ArrayList<Node> arr) {
        System.out.println();
        for (int i = 0; i < arr.size(); i++) {
            Node temp = arr.get(i);
            System.out.print(temp.data + " ");
        }
        System.out.println();
    }

    public static Node buildBst(ArrayList<Node> arr, int min, int max) {
        if (min > max) {
            return null;
        }
        int mid = (min + max) / 2;
        Node newNode = new Node(arr.get(mid).data);
        newNode.left = buildBst(arr, min, mid - 1);
        newNode.right = buildBst(arr, mid + 1, max);
        return newNode;

    }

    public static void printLevelOrderTraversal(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node newNode = queue.remove();
            if (newNode == null && queue.isEmpty()) {
                break;
            }
            if (newNode == null) {
                System.out.println();
                queue.add(null);

            } else {
                System.out.print(newNode.data + " ");
                if (newNode.left != null) {
                    queue.add(newNode.left);
                }
                if (newNode.right != null) {
                    queue.add(newNode.right);
                }
            }

        }
    }

    public static Node balancedBst(Node root) {
        ArrayList<Node> arr = new ArrayList<>();
        inOrderTraversal(root, arr);
        printArrayList(arr);
        Node newRoot = buildBst(arr, 0, arr.size() - 1);
        // printLevelOrderTraversal(newRoot);
        return newRoot;
    }

    public static void main(String[] args) {
        int arr[] = { 8, 6, 5, 3, 10, 11, 12 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = buildBst(root, arr[i]);
        }
        printpreOrderBst(root);
        Node balanceBstRoot = balancedBst(root);
        printLevelOrderTraversal(balanceBstRoot);

    }

}
