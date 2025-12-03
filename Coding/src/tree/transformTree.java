package tree;

import java.util.LinkedList;
import java.util.Queue;

public class transformTree {
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

    public static void printLevelOrderTraversal(Node head) {
        Queue<Node> que = new LinkedList<>();
        que.add(head);
        que.add(null);
        while (!que.isEmpty()) {
            Node currentNode = que.remove();
            if (currentNode == null) {
                if (que.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                    que.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.prev != null) {
                    que.add(currentNode.prev);
                }
                if (currentNode.next != null) {
                    que.add(currentNode.next);
                }
            }
        }
    }

    public static int transformData(Node head) {
        if (head == null) {
            return 0;
        }
        int currData = head.data;
        int leftSum = transformData(head.prev);
        int rightSum = transformData(head.next);
        head.data = leftSum + rightSum;
        return currData + leftSum + rightSum;

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, 6, -1, -1, 7, -1, -1 };
        transformTree tt = new transformTree();
        Node root = tt.buildTree(arr);
        printLevelOrderTraversal(root);
        int rootNode = transformData(root);
        System.out.println("rootNode" + rootNode);
        printLevelOrderTraversal(root);

    }

}
