package BinarySearchTreeRevision;

import java.util.LinkedList;
import java.util.Queue;

public class MirrorBst {

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

    public static Node convertMirror(Node root) {
        if (root == null) {
            return null;
        }
        Node tempNode = root.prev;
        root.prev = convertMirror(root.next);
        root.next = convertMirror(tempNode);
        return root;
    }

    public static void main(String[] args) {
        int nums[] = { 8, 5, 3, 6, 10, 11 };
        Node root = build(nums);
        printLevelOrder(root);
        convertMirror(root);
        System.out.println();
        printLevelOrder(root);

    }

}
