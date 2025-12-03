package BinarySearchTreeRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class convertBSTToBalanceBST {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildBST(Node root, int data) {
        if (root == null) {
            Node newNode = new Node(data);
            return newNode;
        }
        if (data < root.data) {
            root.prev = buildBST(root.prev, data);
        }
        if (data > root.data) {
            root.next = buildBST(root.next, data);
        }
        return root;
    }

    public static Node build(int nums[]) {
        Node root = null;
        for (int i = 0; i < nums.length; i++) {
            root = buildBST(root, nums[i]);
        }
        return root;
    }

    public static void inOrderTraversal(Node root, ArrayList<Node> result) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.prev, result);
        result.add(root);
        inOrderTraversal(root.next, result);

    }

    public static void print(ArrayList<Node> result) {
        for (Node node : result) {
            System.out.print(node.data + " ");
        }
    }

    public static Node buidlBalancedBST(ArrayList<Node> result, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node currentNode = result.get(mid);
        currentNode.prev = buidlBalancedBST(result, start, mid - 1);
        currentNode.next = buidlBalancedBST(result, mid + 1, end);
        return currentNode;
    }

    public static void printLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode == null) {
                if (queue.isEmpty()) {
                    break;
                } else {
                    queue.add(null);
                    System.out.println();
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.prev != null) {
                    queue.add(currentNode.prev);
                }
                if (currentNode.next != null) {
                    queue.add(currentNode.next);
                }

            }

        }
    }

    public static void main(String[] args) {
        int nums[] = { 8, 6, 5, 3, 10, 11, 12 };
        Node root = build(nums);
        ArrayList<Node> result = new ArrayList<>();
        inOrderTraversal(root, result);
        // print(result);
        Node root2 = buidlBalancedBST(result, 0, result.size() - 1);
        printLevelOrder(root2);

    }
}
