package BinarySearchTreeRevision;

import java.util.LinkedList;
import java.util.Queue;

public class sortedArrayBST {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildBST(int nums[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node newRoot = new Node(nums[mid]);
        newRoot.prev = buildBST(nums, start, mid - 1);
        newRoot.next = buildBST(nums, mid + 1, end);
        return newRoot;
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
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = buildBST(arr, 0, arr.length - 1);
        printLevelOrder(root);
    }

}
