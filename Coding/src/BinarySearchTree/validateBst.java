package BinarySearchTree;

public class validateBst {

    static class Node {
        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node buildBinaryTree(Node head, int data) {
        if (head == null) {
            Node newNode = new Node(data);
            return newNode;
        }
        if (data < head.data) {
            head.left = buildBinaryTree(head.left, data);
        } else if (data >= head.data) {
            head.right = buildBinaryTree(head.right, data);
        }
        return head;

    }

    public static void printBstInorder(Node head) {
        if (head == null) {
            return;
        }
        printBstInorder(head.left);
        System.out.print(head.data + "=>");
        printBstInorder(head.right);
    }

    public static void printPreOrder(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.data + "->");
        printPreOrder(head.left);
        printPreOrder(head.right);
    }

    public static boolean isValid(Node head, Node min, Node max) {
        if (head == null) {
            return true;
        }
        if (min != null && head.data <= min.data) {
            return false;
        }
        if (max != null && head.data >= max.data) {
            return false;
        }
        return isValid(head.left, min, head) && isValid(head.right, head, max);
    }

    public static void mirroInBst(Node head) {
        if (head == null) {
            return;
        }
        Node temp = head.left;
        head.left = head.right;
        head.right = temp;
        mirroInBst(head.left);
        mirroInBst(head.right);
    }

    public static void main(String[] args) {
        // int arr[] = { 5, 3, 1, 4, 8 };
        // int arr[] = { 1, 1, 1 };
        int arr[] = { 8, 5, 3, 6, 10, 11 };
        validateBst bst = new validateBst();
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = bst.buildBinaryTree(root, arr[i]);
        }
        printBstInorder(root);
        if (isValid(root, null, null)) {
            System.out.println("valid BSt");
        } else {
            System.out.println("Invalid Bst");
        }
        mirroInBst(root);
        System.out.println("NUll");
        printBstInorder(root);
        System.out.println();
        printPreOrder(root);
    }

}
