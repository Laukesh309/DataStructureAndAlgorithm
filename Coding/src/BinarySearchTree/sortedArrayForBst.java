package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class sortedArrayForBst {
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
            Node temp = queue.remove();
            if (temp == null && queue.isEmpty()) {
                break;
            }
            if (temp == null) {
                System.out.println();
                queue.add(null);
            } else {
                System.out.print(temp.data + " ");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }

            }

        }
    }

    public static Node buildBst(int arr[], int min, int max) {
        if (min > max) {
            return null;
        }
        int mid = (min + max) / 2;
        Node newNode = new Node(arr[mid]);
        // System.out.print("L ");
        newNode.left = buildBst(arr, min, mid - 1);
        // System.out.println();
        // System.out.print("R ");
        newNode.right = buildBst(arr, mid + 1, max);
        return newNode;

    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = buildBst(arr, 0, arr.length - 1);
        printLevelOrder(root);
    }

}
