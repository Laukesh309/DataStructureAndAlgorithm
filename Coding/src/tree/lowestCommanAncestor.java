package tree;

import java.util.ArrayList;

import top150InterviewProblem.DPProblem.easy.happyNum;

public class lowestCommanAncestor {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    static class Info {
        Node ancestor;
        boolean isMet;

        Info(Node ancestor, boolean isMet) {
            this.ancestor = ancestor;
            this.isMet = isMet;
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

    public static Info findcommanAnce(Node head, int n1, int n2) {
        if (head == null) {
            return new Info(null, false);
        }
        if (head.data == n1 || head.data == n2) {
            return new Info(null, true);
        }
        Info left = findcommanAnce(head.prev, n1, n2);
        Info right = findcommanAnce(head.next, n1, n2);
        if (left.isMet && right.isMet && left.ancestor == null && right.ancestor == null) {
            return new Info(head, true);
        }
        if (left.isMet && left.ancestor != null) {
            return left;
        }
        if (right.isMet && right.ancestor != null) {
            return right;
        }
        if (left.isMet && left.ancestor == null || right.isMet && right.ancestor == null) {
            return new Info(null, true);
        }
        return new Info(null, false);
    }

    public static boolean findCommanPath(Node head, int n1, ArrayList<Node> result) {
        if (head == null) {
            return false;
        }

        if (head.data == n1) {
            result.add(head);
            return true;
        }
        boolean isLeft = findCommanPath(head.prev, n1, result);
        boolean isRight = findCommanPath(head.next, n1, result);
        if (isLeft || isRight) {
            result.add(head);
            return true;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        ArrayList<Node> result1 = new ArrayList<>();
        ArrayList<Node> result2 = new ArrayList<>();
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        lowestCommanAncestor nca = new lowestCommanAncestor();
        Node root = nca.buildTree(arr);
        int n1 = 4;
        int n2 = 3;
        // findCommanPath(root, n2, result1);
        // findCommanPath(root, n1, result2);
        // for (Node i : result1) {
        // System.out.println(i.data);
        // }
        Info result = findcommanAnce(root, n1, n2);
        System.out.println(result.ancestor.data);

    }
}
