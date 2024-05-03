package tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
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

    static class BinaryTreeBuild {
        static int index = -1;

        public static Node buildTree(int nodes[]) {
            index++;
            if (nodes[index] == -1) {
                return null;
            }
            Node newNode = new Node(nodes[index]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

        }
    }

    public static void preOrderTraversal(Node node) {
        if (node == null) {
            System.out.print("-1 ");
            return;
        }
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void inOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    public static void postOrderTraversal(Node node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
        return;
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            Node currNode = q.remove();
            if (currNode == null) {
                System.out.println();
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                System.out.print(currNode.data + " ");
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }

            }
        }

    }

    public static int totalNode = -1;

    public static int countOfNode(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int leftCount = countOfNode(rootNode.left);
        int rightCount = countOfNode(rootNode.right);
        return leftCount + rightCount + 1;

    }

    public static int sumOfNode(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int leftSum = sumOfNode(rootNode.left);
        int rightSum = sumOfNode(rootNode.right);
        return leftSum + rightSum + rootNode.data;
    }

    public static int HeightOfTree(Node rootNode) {
        if (rootNode == null) {
            return 0;
        }
        int leftHeight = HeightOfTree(rootNode.left);
        int rightHeight = HeightOfTree(rootNode.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public static void main(String[] args) {
        int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTreeBuild tree = new BinaryTreeBuild();
        Node rootNode = tree.buildTree(node);
        // preOrderTraversal(rootNode);
        // inOrderTraversal(rootNode);
        // postOrderTraversal(rootNode);
        // levelOrderTraversal(rootNode);
        // int totalNumberOfNode = countOfNode(rootNode);
        // int totalNodeSum = sumOfNode(rootNode);
        int totalHeightOfTree = HeightOfTree(rootNode);
        System.out.println(totalHeightOfTree);
    }

}
