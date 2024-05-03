package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree1 {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printInOrderTraversal(Node head) {
        if (head == null) {
            System.out.println("Null");
            return;
        }
        System.out.print("L ");
        printInOrderTraversal(head.left);
        System.out.println();
        System.out.println(head.data);
        System.out.print("R ");
        printInOrderTraversal(head.right);
    }

    public static void printLevelOrderTraversal(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            if (temp == null && queue.isEmpty()) {
                break;
            }
            if (temp == null) {
                queue.add(null);
                System.out.println();
            } else {
                System.out.print(temp.data + " =>");
                if (temp.left != null) {
                    queue.add(temp.left);
                }
                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }

        }

    }

    public static Node buildBst(Node node, int data) {
        if (node == null) {
            Node newNode = new Node(data);
            return newNode;
        }
        if (data < node.data) {
            node.left = buildBst(node.left, data);
        } else {
            node.right = buildBst(node.right, data);
        }
        return node;
    }

    public static boolean searchKey(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        System.out.print(root.data);
        System.out.println();
        if (root.data > key) {
            System.out.print("L ");
            return searchKey(root.left, key);
        }
        System.out.print("R ");
        return searchKey(root.right, key);
    }

    public static Node findRightPredesesor(Node head) {
        if (head.left == null && head.right == null) {
            return head;
        }
        return findRightPredesesor(head.left);
    }

    public static Node deleteNode(Node head, int data) {
        if (head == null) {
            return null;
        }

        if (data < head.data) {
            head.left = deleteNode(head.left, data);
        } else if (data > head.data) {
            head.right = deleteNode(head.right, data);
        } else {
            /// For Leaf Node deletion
            if (head.left == null && head.right == null) {
                return null;
            }

            // For Child Having Single Child
            if (head.left == null || head.right == null) {
                if (head.left != null) {
                    return head.left;
                }
                return head.right;
            }

            // For Two Children
            Node predeccessorNode = findRightPredesesor(head.right);
            head.data = predeccessorNode.data;
            head.right = deleteNode(head.right, predeccessorNode.data);
        }

        return head;
    }

    public static void printRangeValue(Node head, int min, int max) {
        if (head == null) {
            return;
        }
        if (head.data >= min && head.data <= max) {
            System.out.println(head.data);
            printRangeValue(head.left, min, max);
            printRangeValue(head.right, min, max);
        } else {
            if (head.data < min) {
                printRangeValue(head.right, min, max);
            } else {
                printRangeValue(head.left, min, max);
            }
        }
    }

    public static void printRootToLeafPath(Node head, ArrayList<Integer> arr) {
        if (head == null) {
            return;
        }
        arr.add(head.data);
        if (head.left == null && head.right == null) {
            System.out.println(arr);
        }
        printRootToLeafPath(head.left, arr);
        printRootToLeafPath(head.right, arr);
        arr.remove(arr.size() - 1);

    }

    public static void main(String[] args) {
        // int arr[] = { 4, 2, 1, 3, 5, 6 };
        int arr[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        ArrayList<Integer> data = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            root = buildBst(root, arr[i]);
        }
        // printLevelOrderTraversal(root);
        // System.out.println();
        // System.out.println(searchKey(root, 1));
        // printInOrderTraversal(root);
        // System.out.println();
        // deleteNode(root, 5);
        // printLevelOrderTraversal(root);
        // printRangeValue(root, 10, 12);
        printRootToLeafPath(root, data);
    }

}
