package TreeStriver;

import java.util.Stack;

import Stack.pushBottom;

public class createTree {

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

    static class Pair {
        int height;
        int diameters;

        Pair(int height, int diameters) {
            this.height = height;
            this.diameters = diameters;
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

    public static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void InOrder(Node root) {
        if (root == null) {
            return;
        }

        InOrder(root.left);
        System.out.print(root.data + " ");
        InOrder(root.right);
    }

    public static void iterativePreOrder(Node root) {
        Stack<Node> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()) {
            Node curNode = st.pop();
            System.out.print(curNode.data + " ");
            if (curNode.right != null) {
                st.add(curNode.right);
            }
            if (curNode.left != null) {
                st.add(curNode.left);

            }

        }
    }

    public static void iterativeInOrder(Node root) {
        Stack<Node> st = new Stack<>();
        Node curNode = root;

        while (true) {
            if (curNode != null) {
                st.push(curNode);
                curNode = curNode.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                Node node = st.pop();
                System.out.print(node.data + " ");
                curNode = node.right;
            }

        }
    }

    public static Pair findDiaMeter(Node root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = findDiaMeter(root.left);
        Pair right = findDiaMeter(root.right);
        int currentDiamter = Math.max(1 + left.height + right.height, Math.max(left.diameters, right.diameters));
        int maxHeight = Math.max(left.height, right.height);
        return new Pair(maxHeight + 1, currentDiamter);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        Node root = createTree(arr);
        // preOrder(root);
        // InOrder(root);
        // iterativePreOrder(root);
        // iterativeInOrder(root);
        System.out.println(findDiaMeter(root).diameters - 1);

    }

}
