package top150InterviewProblem.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class kthLevelOfTree {
    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    int currentIndex = -1;

    public Node builtTree(int nodes[]) {
        currentIndex++;
        if (nodes[currentIndex] == -1) {
            return null;
        }
        Node curNode = new Node(nodes[currentIndex]);
        curNode.prev = builtTree(nodes);
        curNode.next = builtTree(nodes);
        return curNode;

    }

    public static void printLevelOrder(Node root, int k) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        que.add(null);
        int counter = 1;
        while (!que.isEmpty() && counter < k) {
            Node currNode = que.remove();
            if (currNode == null) {
                if (que.isEmpty()) {
                    break;
                } else {
                    counter++;
                    que.add(null);
                }
            } else {
                if (currNode.prev != null) {
                    que.add(currNode.prev);
                }
                if (currNode.next != null) {
                    que.add(currNode.next);
                }
            }
        }
        if (que.isEmpty()) {
            return;
        }
        Node curNode = que.remove();
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = que.remove();
        }
        return;
    }

    public static void kthOrder(Node head, int level, int k) {
        if (head == null) {
            return;
        }
        if (level == k) {
            System.out.print(head.data + " ");
            return;
        }
        kthOrder(head.prev, level + 1, k);
        kthOrder(head.next, level + 1, k);
        return;

    }

    public static Node lowestCommonAncestor(Node root, int n1, int n2) {
        if (root == null) {
            return null;
        }
        if (isLowestCommonAncestor(root.prev, root.next, n1, n2)) {
            return lowestCommonAncestor(root, n1, n2)

        }
    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        kthLevelOfTree kt = new kthLevelOfTree();
        Node root = kt.builtTree(nodes);
        printLevelOrder(root, 2);
        System.out.println();
        kthOrder(root, 1, 2);

    }

}
