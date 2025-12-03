package tree;

import java.util.LinkedList;
import java.util.Queue;

public class kthLevelTree {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    int currentIndex = -1;

    public Node buildTree(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[currentIndex]);
        newNode.prev = buildTree(arr);
        newNode.next = buildTree(arr);
        return newNode;
    }

    public static void printKLevel(Node root, int k) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        int level = 1;
        while (!que.isEmpty()) {
            Node element = que.remove();
            if (element == null) {
                if (que.isEmpty()) {
                    break;
                } else {
                    que.add(null);
                }
                level++;
            } else {
                if (level == k) {
                    System.out.print(element.data + " ");
                }
                if (element.prev != null) {
                    que.add(element.prev);
                }
                if (element.next != null) {
                    que.add(element.next);
                }
            }

        }
    }

    public static void printKthLevel(Node root, int level, int k) {
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }
        if (root == null) {
            return;
        }
        printKthLevel(root.prev, level + 1, k);
        printKthLevel(root.next, level + 1, k);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        kthLevelTree kt = new kthLevelTree();
        Node root = kt.buildTree(arr);
        // printKLevel(root, 3);
        printKthLevel(root, 1, 3);

    }

}
