package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertBinaryTree {
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

    public static void printLevelOrderTree(Node root) {
        Queue<Node> que = new LinkedList<>();
        List<List<Integer>> ls = new ArrayList<>();
        que.add(root);
        que.add(null);
        List<Integer> temp = new ArrayList<>();
        while (!que.isEmpty()) {
            Node currentNode = que.remove();
            if (currentNode == null) {
                ls.add(temp);
                temp = new ArrayList<>();
                if (que.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                    que.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                temp.add(currentNode.data);
                if (currentNode.prev != null) {
                    que.add(currentNode.prev);
                }
                if (currentNode.next != null) {
                    que.add(currentNode.next);
                }
            }

        }
        System.out.println(ls);
    }

    public static Node transform(Node head) {
        if (head == null) {
            return null;
        }
        Node currprev = head.prev;
        head.prev = transform(head.next);
        head.next = transform(currprev);
        return head;

    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 1, -1, -1, 3, -1, -1, 7, 6, -1, -1, 9, -1, -1 };
        InvertBinaryTree ibt = new InvertBinaryTree();
        Node root = ibt.buildTree(arr);
        printLevelOrderTree(root);
        System.out.println(">>>>>");
        transform(root);
        printLevelOrderTree(root);
    }
}
