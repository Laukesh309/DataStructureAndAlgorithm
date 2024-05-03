package BinaryTreeJava;

import java.util.LinkedList;
import java.util.Queue;

public class buildPreOrderTree {

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

    static class BinaryTree {
        public static int currentIndex = -1;
        public static int max = -1;

        public static Node buildTree(int arr[]) {
            currentIndex++;
            if (arr[currentIndex] == -1) {
                return null;
            }
            Node newNode = new Node(arr[currentIndex]);
            newNode.left = buildTree(arr);
            newNode.right = buildTree(arr);
            return newNode;

        }

        public static void preOrderTraversal(Node head) {
            if (head == null) {
                return;
            }
            System.out.print(head.data + " ");
            preOrderTraversal(head.left);
            preOrderTraversal(head.right);
            return;
        }

        public static void inOrderTraversal(Node head) {
            if (head == null) {
                return;
            }
            inOrderTraversal(head.left);
            System.out.print(head.data + " ");
            inOrderTraversal(head.right);

        }

        public static void postOrdertraversal(Node head) {
            if (head == null) {
                return;
            }
            postOrdertraversal(head.left);
            postOrdertraversal(head.right);
            System.out.print(head.data + " ");
        }

        public static void levelOrderTraversal(Queue<Node> queue) {

            while (!queue.isEmpty()) {
                Node tempNode = queue.remove();
                if (tempNode != null) {
                    System.out.print(tempNode.data + " ");
                    Node leftNode = tempNode.left;
                    Node rightNode = tempNode.right;
                    if (leftNode != null) {
                        queue.add(leftNode);
                    }
                    if (rightNode != null) {
                        queue.add(rightNode);
                    }
                } else {
                    System.out.println();
                    if (queue.isEmpty()) {
                        break;
                    } else {
                        queue.add(null);
                    }
                }

            }

        }

        public static int findHeight(Node head, int max, int currentNodeValue) {
            if (head == null) {
                if (currentNodeValue > max) {
                    max = currentNodeValue;
                }
                return max;
            }
            currentNodeValue++;
            int leftHeight = findHeight(head.left, max, currentNodeValue);
            int rightHeight = findHeight(head.right, max, currentNodeValue);
            return Math.max(leftHeight, rightHeight);
        }

        public static int findHeight2(Node head) {
            if (head == null) {
                return 0;
            }
            int leftHeight = findHeight2(head.left);
            int rightHeight = findHeight2(head.right);
            return Math.max(leftHeight, rightHeight) + 1;
        }

        public static int totalNumberOfNode(Node head) {
            if (head == null) {
                return 0;
            }
            return totalNumberOfNode(head.left) + totalNumberOfNode(head.right) + 1;
        }

        public static int totalSumOfNode(Node head) {
            if (head == null) {
                return 0;
            }
            return totalSumOfNode(head.left) + totalSumOfNode(head.right) + head.data;
        }

        public static int diameterOfNode(Node head) {
            if (head == null) {
                return 0;
            }
            int leftSubTreeMaxHeight = findHeight2(head.left);
            int rightSubTreeMaxHeight = findHeight2(head.right);
            int totalHeight = leftSubTreeMaxHeight + rightSubTreeMaxHeight + 1;

            return Math.max(Math.max(diameterOfNode(head.left), diameterOfNode(head.right)), totalHeight);
        }
    }

    public static void main(String[] args) {
        // int node[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        // int node[] = { 1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1 };
        // int node[] = { 1, 2, 4, 9, -1, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1 };
        int node[] = { 1, 2, 4, 9, 10, -1, -1, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(node);
        // System.out.println(root.data);
        bt.preOrderTraversal(root);
        System.out.println();
        bt.inOrderTraversal(root);
        System.out.println();
        bt.postOrdertraversal(root);
        System.out.println();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        bt.levelOrderTraversal(queue);
        System.out.println("max Height=> " + bt.findHeight(root, bt.max, 0));
        System.out.println("max Height second implementation => " + bt.findHeight2(root));
        System.out.println("totalNumber of Node => " + bt.totalNumberOfNode(root));
        System.out.println("totalNode Sum => " + bt.totalSumOfNode(root));
        System.out.println("diamether of Node =>" + bt.diameterOfNode(root));
        // System.out.println(bt.max);

    }

}
