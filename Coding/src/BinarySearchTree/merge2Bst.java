package BinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class merge2Bst {
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

    public static Node buildBst(ArrayList<Integer> arr, int min, int max) {
        if (min > max) {
            return null;
        }
        int mid = (min + max) / 2;
        Node newNode = new Node(arr.get(mid));
        newNode.left = buildBst(arr, min, mid - 1);
        newNode.right = buildBst(arr, mid + 1, max);
        return newNode;
    }

    public static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node == null && queue.isEmpty()) {
                break;
            }
            if (node == null) {
                System.out.println();
                queue.add(null);
            } else {
                System.out.print(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        System.out.println();
    }

    public static void inOrderTraversal(Node head, ArrayList<Node> arr) {
        if (head == null) {
            return;
        }
        inOrderTraversal(head.left, arr);
        arr.add(head);
        inOrderTraversal(head.right, arr);
    }

    public static void printArrayList(ArrayList<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {

            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
    }

    public static void mergeTwoArray(ArrayList<Node> first, ArrayList<Node> second, ArrayList<Integer> third) {
        int firstPointer = 0;
        int secondPointer = 0;
        while (firstPointer < first.size() && secondPointer < second.size()) {
            Node firstNode = first.get(firstPointer);
            Node secondNode = second.get(secondPointer);
            if (firstNode.data < secondNode.data) {
                third.add(firstNode.data);
                firstPointer++;
            }
            if (firstNode.data > secondNode.data) {
                secondPointer++;
                third.add(secondNode.data);
            }
        }
        while (firstPointer < first.size()) {
            third.add(first.get(firstPointer).data);
            firstPointer++;
        }
        while (secondPointer < second.size()) {
            third.add(second.get(secondPointer).data);
            secondPointer++;
        }
    }

    public static Node mergeTwoBst(Node firstNode, Node secondNode) {
        ArrayList<Node> firstArray = new ArrayList<>();
        ArrayList<Node> secondArray = new ArrayList<>();
        inOrderTraversal(firstNode, firstArray);
        inOrderTraversal(secondNode, secondArray);
        ArrayList<Integer> thirdArray = new ArrayList<>();
        mergeTwoArray(firstArray, secondArray, thirdArray);
        System.out.println("thirdPointer");
        printArrayList(thirdArray);
        Node newRoot = buildBst(thirdArray, 0, thirdArray.size() - 1);
        return newRoot;

    }

    public static void main(String[] args) {
        // int arr[] = { 1, 2, 4 };
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);
        // int arr2[] = { 3, 9, 12 };
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(3);
        arr2.add(9);
        arr2.add(12);
        merge2Bst mb = new merge2Bst();
        Node firstRoot = mb.buildBst(arr, 0, arr.size() - 1);
        Node secondRoot = mb.buildBst(arr2, 0, arr2.size() - 1);
        mb.printLevelOrder(firstRoot);
        System.out.println("SecondTree");
        mb.printLevelOrder(secondRoot);
        System.out.println("merging");
        Node rootMerge = mb.mergeTwoBst(firstRoot, secondRoot);
        System.out.println("lastMerge-->");
        mb.printLevelOrder(rootMerge);

    }

}
