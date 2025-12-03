package BinarySearchTreeRevision;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class searchBST {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buidlBSTNode(Node root, int data) {
        if (root == null) {
            Node newNode = new Node(data);
            return newNode;
        }
        if (data < root.data) {
            root.prev = buidlBSTNode(root.prev, data);
        }
        if (data > root.data) {
            root.next = buidlBSTNode(root.next, data);
        }
        return root;

    }

    public static Node buildBST(int nums[]) {
        Node root = null;
        for (int i = 0; i < nums.length; i++) {
            root = buidlBSTNode(root, nums[i]);
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

    public static boolean searchBST(Node root, int key) {

        if (root == null) {
            return false;
        }
        System.out.println(root.data);
        if (root.data == key) {
            return true;
        }
        if (key < root.data) {
            return searchBST(root.prev, key);
        }
        if (key > root.data) {
            return searchBST(root.next, key);
        }
        return false;
    }

    public static Node inOrderSuccessor(Node root) {
        if (root.prev == null) {
            return root;
        }
        return inOrderSuccessor(root.prev);

    }

    public static Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (value < root.data) {
            root.prev = deleteNode(root.prev, value);
        }
        if (value > root.data) {
            root.next = deleteNode(root.next, value);
        }
        if (root.data == value) {

            // leaf node
            if (root.prev == null && root.next == null) {
                return null;
            }
            // single node
            if (root.prev == null) {
                return root.next;
            }
            if (root.next == null) {
                return root.prev;
            }
            // 2 childtren
            Node IS = inOrderSuccessor(root.next);
            root.data = IS.data;
            root.next = deleteNode(root.next, IS.data);
        }
        return root;

    }

    public static void printRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (k1 <= root.data && root.data <= k2) {
            System.out.println(root.data);
            printRange(root.prev, k1, k2);
            printRange(root.next, k1, k2);
        }
        if (root.data < k1) {
            printRange(root.next, k1, k2);
        }
        if (root.data > k2) {
            printRange(root.prev, k1, k2);
        }
        return;
    }

    public static void printNode(List<Node> result) {
        for (Node node : result) {
            System.out.print(node.data + " ");
        }
    }

    public static void printRootToLeaf(Node root, List<Node> result) {
        if (root == null) {
            return;
        }
        result.add(root);
        if (root.prev == null && root.next == null) {

            printNode(result);
            result.remove(result.size() - 1);
            System.out.println();
            return;
        }
        printRootToLeaf(root.prev, result);
        printRootToLeaf(root.next, result);
        result.remove(result.size() - 1);
        return;
    }

    public static boolean validateBst(Node root) {
        if (root == null) {
            return true;
        }
        if (root.prev != null && root.next != null && root.prev.data < root.data && root.next.data > root.data) {
            return validateBst(root.prev) && validateBst(root.next);
        }
        if (root.prev == null) {
            return validateBst(root.next);
        }
        if (root.next == null) {
            return validateBst(root.prev);
        }
        return false;
    }

    public static void main(String[] args) {

        int nums[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = buildBST(nums);
        // printLevelOrderTraversal(root);
        System.out.println();
        // System.out.println(searchBST(root, 1));
        // root = deleteNode(root, 5);
        // printLevelOrderTraversal(root);
        // printRange(root, 5, 12);
        // printRootToLeaf(root, new ArrayList<>());
        System.out.println(validateBst(root));

    }

}
