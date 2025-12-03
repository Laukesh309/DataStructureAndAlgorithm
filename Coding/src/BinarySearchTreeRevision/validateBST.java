package BinarySearchTreeRevision;

import java.util.LinkedList;
import java.util.Queue;

public class validateBST {
    static class Node {
        int data;
        Node next;
        Node prev;

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

    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        }
        if (max != null && root.data >= max.data) {
            return false;
        }
        return isValid(root.prev, min, root) && isValid(root.next, root, max);
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
        int nums[] = { 5, 3, 1, 4, 6, 7 };
        Node root = build(nums);
        printLevelOrder(root);
        System.out.println(isValid(root, null, null));
    }

}
