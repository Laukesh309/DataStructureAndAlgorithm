package BinarySearchTree;

import java.util.Stack;

import recursion.LoveBabbar.binarySearch;

public class buildBinaryTreee {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static int counter = -1;

    public static Node buildTree(Node root, int data) {
        if (root == null) {
            Node newNode = new Node(data);
            root = newNode;
            return root;
        }
        if (data > root.data) {
            root.next = buildTree(root.next, data);
        }
        if (data < root.data) {
            root.prev = buildTree(root.prev, data);
        }
        return root;
    }

    public static void printInorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        printInorderTraversal(root.prev);
        System.out.print(root.data + " ");
        printInorderTraversal(root.next);
        return;
    }

    public static boolean searchInBst(Node head, int key) {
        if (head == null) {
            return false;
        }
        if (head.data == key) {
            return true;
        }
        if (head.data > key) {
            return searchInBst(head.prev, key);
        }
        if (head.data < key) {
            return searchInBst(head.next, key);
        }
        return false;
    }

    public static Node findLeafNode(Node head) {
        if (head.prev == null) {
            return head;
        }
        return findLeafNode(head.prev);
    }

    public static Node deleteLeafNode(Node head, int key) {
        if (head == null) {
            return null;
        }
        if (head.data == key && head.prev != null && head.next != null) {
            Node leafNode = findLeafNode(head.next);
            int keyValue = leafNode.data;
            leafNode.next = deleteLeafNode(head.next, keyValue);
            leafNode.prev = head.prev;
            return leafNode;

        }
        if (head.data == key && head.prev == null && head.next != null) {
            Node nextNode = head.next;
            head.next = null;
            return nextNode;
        }
        if (head.data == key && head.prev != null && head.next == null) {
            Node nextNode = head.prev;
            head.prev = null;
            return nextNode;
        }
        if (head.data == key && head.prev == null && head.next == null) {
            return null;
        }
        if (head.data > key) {
            head.prev = deleteLeafNode(head.prev, key);
        }
        if (head.data < key) {
            head.next = deleteLeafNode(head.next, key);
        }
        return head;
    }

    public static void findValueInRange(Node root, int min, int max) {
        if (root == null) {
            return;
        }
        if (root.data == min) {
            System.out.print(root.data + " ");
            findValueInRange(root.next, root.data, max);
        }
        if (root.data == max) {
            System.out.print(root.data + " ");
            findValueInRange(root.prev, min, root.data);
        }
        if (root.data > min && root.data < max) {
            System.out.print(root.data + " ");
            findValueInRange(root.prev, min, root.data);
            findValueInRange(root.next, root.data, max);
        }
        if (root.data < min) {
            findValueInRange(root.next, min, max);
        } else if (root.data > max) {
            findValueInRange(root.prev, min, max);
        }

    }

    public static void rootToLeafPath(Node head, Stack<Integer> stc) {
        if (head == null) {
            return;
        }
        stc.push(head.data);
        if (head.prev == null && head.next == null) {
            System.out.println(stc);
        }
        rootToLeafPath(head.prev, stc);
        rootToLeafPath(head.next, stc);
        stc.pop();
        return;

    }

    public static void main(String[] args) {
        // int arr[] = { 5, 1, 3, 4, 2, 7 };
        // int arr[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        int arr[] = { 20, 10, 5, 2, 1, 3, 7, 6, 8, 14, 12, 11, 13, 15, 40, 25, 23,
                21, 24, 26, 45 };
        // int arr[] = { 8, 5, 3, 6, 10, 11, 14 };
        buildBinaryTreee bt = new buildBinaryTreee();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = buildTree(root, arr[i]);
        }
        printInorderTraversal(root);
        System.out.println();
        // System.out.println(searchInBst(root, 15));
        // deleteLeafNode(root, 10);
        // printInorderTraversal(root);

        // root = deleteLeafNode(root, 20);
        // System.out.println();
        // printInorderTraversal(root);
        // System.out.println(root.data);
        // findValueInRange(root, 4, 24);
        Stack<Integer> stc = new Stack<>();
        rootToLeafPath(root, stc);
    }

}
