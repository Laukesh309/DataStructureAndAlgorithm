package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class sizeofLargestBst {

    static class Node {
        int data;
        Node left;
        Node right;
        int min;
        int max;
        int size;

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

    public static void printInOrder(Node head) {
        if (head == null) {
            return;
        }
        printInOrder(head.left);
        System.out.print(head.data + " ");
        printInOrder(head.right);
        System.out.println();
    }

    public static int currentIndex = -1;

    public static Node builtBt(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[currentIndex]);
        newNode.left = builtBt(arr);
        newNode.right = builtBt(arr);
        return newNode;
    }

    public static int findSizeOfLargestBst() {

        return 0;
    }

    public static void main(String[] args) {
        int arr[] = { 50, 30, 5, -1, -1, 20, -1, -1, 60, 45, -1, -1, 70, 65, -1, -1, 80, -1, -1 };
        Node root = builtBt(arr);
        // printLevelOrder(root);
        printInOrder(root);

    }

}
