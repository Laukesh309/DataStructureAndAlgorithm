package tree;

public class BinarySearchTree {

    static class Node {
        int data;
        Node right;
        Node left;

        Node(int data) {
            this.data = data;
            this.right = null;
            this.left = null;
        }
    }

    public static Node buildBinaryTree(Node rootNode, int value) {
        if (rootNode == null) {
            Node newNode = new Node(value);
            return newNode;
        }
        if (rootNode.data > value) {
            rootNode.left = buildBinaryTree(rootNode.left, value);
        } else {
            rootNode.right = buildBinaryTree(rootNode.right, value);
        }
        return rootNode;
    }

    public static void printInOrder(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        printInOrder(rootNode.left);
        System.out.print(rootNode.data + " ");
        printInOrder(rootNode.right);
        return;
    }

    public static boolean searchNode(Node rootNode, int key) {
        if (rootNode == null) {
            return false;
        }
        if (rootNode.data == key) {
            return true;
        }
        if (rootNode.data > key) {
            return searchNode(rootNode.left, key);
        } else {
            return searchNode(rootNode.right, key);
        }
    }

    public static void main(String[] args) {

        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node rootNode = null;
        for (int i = 0; i < values.length; i++) {
            rootNode = buildBinaryTree(rootNode, values[i]);
        }
        // printInOrder(rootNode);
        System.out.println(searchNode(rootNode, 3));

    }

}
