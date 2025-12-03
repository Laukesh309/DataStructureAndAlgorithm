package BinarySearchTreeRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class mergeBST {

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

    public static void printLevelOrderTraversal(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
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

    public static void getInOrderResult(Node root, ArrayList<Node> result) {
        if (root == null) {
            return;
        }
        getInOrderResult(root.prev, result);
        result.add(root);
        getInOrderResult(root.next, result);

    }

    public static void printArrayList(ArrayList<Node> result) {
        for (Node node : result) {
            System.out.print(node.data + " ");
        }
    }

    public static ArrayList<Node> mergeList(ArrayList<Node> result1, ArrayList<Node> result2) {
        int first = 0;
        int second = 0;
        ArrayList<Node> result = new ArrayList<>();
        while (first < result1.size() && second < result2.size()) {
            Node firstElement = result1.get(first);
            Node secondElement = result2.get(second);
            if (firstElement.data < secondElement.data) {
                result.add(firstElement);
                first++;
            } else {
                result.add(secondElement);
                second++;
            }

        }
        while (first < result1.size()) {
            result.add(result1.get(first));
            first++;
        }
        while (second < result2.size()) {
            result.add(result2.get(second));
            second++;
        }
        return result;
    }

    public static Node buidlBalancedBST(ArrayList<Node> finalResult, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node newNode = finalResult.get(mid);
        newNode.prev = buidlBalancedBST(finalResult, start, mid - 1);
        newNode.next = buidlBalancedBST(finalResult, mid + 1, end);
        return newNode;
    }

    public static void main(String[] args) {
        int num1[] = { 2, 1, 4 };
        int num2[] = { 9, 3, 12 };
        Node root1 = build(num1);
        Node root2 = build(num2);
        // printLevelOrderTraversal(root1);
        System.out.println();
        // printLevelOrderTraversal(root2);
        ArrayList<Node> result1 = new ArrayList<>();
        ArrayList<Node> result2 = new ArrayList<>();
        getInOrderResult(root1, result1);

        getInOrderResult(root2, result2);
        printArrayList(result1);
        System.out.println();
        printArrayList(result2);
        ArrayList<Node> finalResult = mergeList(result1, result2);
        System.out.println("-->");
        printArrayList(finalResult);
        Node finalRoot = buidlBalancedBST(finalResult, 0, finalResult.size() - 1);
        System.out.println();
        System.out.println();
        printLevelOrderTraversal(finalRoot);

    }

}
