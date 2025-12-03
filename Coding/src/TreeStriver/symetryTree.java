package TreeStriver;

import java.util.LinkedList;
import java.util.Queue;

public class symetryTree {
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

    static int currentIndex = -1;

    public static Node createTree(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node currentNode = new Node(arr[currentIndex]);
        currentNode.left = createTree(arr);
        currentNode.right = createTree(arr);
        return currentNode;

    }

    public static boolean isSymmetry(Node left, Node right) {
        if (left == null || right == null) {
            return left == right;
        }
        if (left.data != right.data) {
            return false;
        }
        return isSymmetry(left.left, right.right) && isSymmetry(left.right, right.left);
    }

    public static boolean findSymetry(Node root) {
        if (root == null) {
            return true;
        }
        return isSymmetry(root.left, root.right);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, -1, -1, 4, -1, -1, 2, 4, -1, -1, 3, -1, -1 };
        Node root = createTree(arr);
        System.out.println(findSymetry(root));
    }

}
