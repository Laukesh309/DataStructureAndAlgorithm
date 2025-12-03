package top150InterviewProblem.Tree;

import java.util.LinkedList;
import java.util.Queue;

import Stack.pushBottom;

public class heightofTree {

    static class Node {
        int data;
        Node prevNode;
        Node nextNode;

        Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        static int currIndex = -1;

        public Node buildTree(int node[]) {
            currIndex++;
            if (node[currIndex] == -1) {
                return null;
            }
            Node newNode = new Node(node[currIndex]);
            newNode.prevNode = buildTree(node);
            newNode.nextNode = buildTree(node);
            return newNode;
        }

        // preOrderTraversal // root-->leftSubTree--->rightSubTree
        public void preOrderTraversal(Node head) {
            if (head == null) {
                System.out.print("-1  ");
                return;
            }
            System.out.print(head.data + " ");
            preOrderTraversal(head.prevNode);
            preOrderTraversal(head.nextNode);
        }

        // InOrderTraversal // leftSubtre->root--> rightSubTree
        public void inOrderTraversal(Node head) {
            if (head == null) {
                System.out.print("-1  ");
                return;
            }
            inOrderTraversal(head.prevNode);
            System.out.print(head.data + "  ");
            inOrderTraversal(head.nextNode);
        }

        // postOrder Traversal // leftSubTree-->rightSubTree-->root
        public void postOrderTraversal(Node head) {
            if (head == null) {
                System.out.print("-1 ");
                return;
            }
            postOrderTraversal(head.prevNode);
            postOrderTraversal(head.nextNode);
            System.out.print(head.data + " ");
        }
        // levelOrderTraversal //

        public void levelOrderTraversal(Node head) {
            Queue<Node> que = new LinkedList<>();
            que.add(head);
            que.add(null);
            while (!que.isEmpty()) {
                Node currentRoot = que.remove();
                if (currentRoot == null) {
                    if (que.isEmpty()) {
                        break;
                    } else {
                        System.out.println();
                        que.add(null);
                    }
                } else {
                    System.out.print(currentRoot.data + " ");
                    if (currentRoot.prevNode != null) {
                        que.add(currentRoot.prevNode);
                    }
                    if (currentRoot.nextNode != null) {
                        que.add(currentRoot.nextNode);
                    }
                }
            }

        }

        public int findHeigtOfTree(Node root) {
            if (root == null) {
                return 0;
            }
            return 1 + Math.max(findHeigtOfTree(root.prevNode), findHeigtOfTree(root.nextNode));
        }

    }

    public static void main(String[] args) {
        int nodes[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        BinaryTree bt = new BinaryTree();
        Node root = bt.buildTree(nodes);
        System.out.println("rootNode " + root.data);
        bt.preOrderTraversal(root);
        System.out.println();
        bt.inOrderTraversal(root);
        System.out.println();
        bt.postOrderTraversal(root);
        System.out.println("lavelOrder Traversal->");
        bt.levelOrderTraversal(root);
        System.out.println();
        System.out.println(bt.findHeigtOfTree(root));

    }

}
