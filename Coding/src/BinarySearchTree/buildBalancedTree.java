package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class buildBalancedTree {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node builtBalancedBinaryTree(int arr[], int minIndex, int maxIndex) {
        if (minIndex > maxIndex) {
            return null;
        }
        int midIndex = (minIndex + maxIndex) / 2;
        Node newNode = new Node(arr[midIndex]);
        newNode.left = builtBalancedBinaryTree(arr, minIndex, midIndex - 1);
        newNode.right = builtBalancedBinaryTree(arr, midIndex + 1, maxIndex);
        return newNode;
    }

    public static void printLevelOrder(Queue<Node> queue) {
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

    static int currentIndex = -1;

    public static Node buildBt(int arr2[]) {
        currentIndex++;
        if (arr2[currentIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr2[currentIndex]);
        newNode.left = buildBt(arr2);
        newNode.right = buildBt(arr2);
        return newNode;

    }

    public static void printInOrder(Node root) {
        if (root == null) {
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data + "=>");
        printInOrder(root.right);
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        int arr2[] = { 50, 30, 5, -1, -1, 20, -1, -1, 60, 45, -1, -1, 70, 65, -1, -1, 80, -1, -1 };
        buildBalancedTree bt = new buildBalancedTree();
        Node btRoot = buildBt(arr2);
        Node root = builtBalancedBinaryTree(arr, 0, arr.length - 1);
        printInOrder(root);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        System.out.println();
        printLevelOrder(queue);

    }

}
