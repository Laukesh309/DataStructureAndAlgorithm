package top150InterviewProblem.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class createTree {

    static public class Node {
        int data;
        Node leftPointer;

        Node rightPointer;

        Node(int data) {
            this.data = data;
        }
    }

    static int currentIndex = -1;

    public static Node createTree(int arr[]) {
        currentIndex++;
        if (arr[currentIndex] == -1) {
            return null;
        }
        Node newNode = new Node(arr[currentIndex]);
        newNode.leftPointer = createTree(arr);
        newNode.rightPointer = createTree(arr);
        return newNode;
    }

    public static void preOrderTraversal(Node head) {
        if (head == null) {
            return;
        }
        System.out.println(head.data);
        preOrderTraversal(head.leftPointer);
        preOrderTraversal(head.rightPointer);
    }

    public static void inOrderTraversal(Node head) {
        if (head == null) {
            return;
        }
        inOrderTraversal(head.leftPointer);
        System.out.println(head.data);
        inOrderTraversal(head.rightPointer);

    }

    public static void postOrderTraversal(Node head) {
        if (head == null) {
            return;
        }
        postOrderTraversal(head.leftPointer);
        postOrderTraversal(head.rightPointer);
        System.out.println(head.data);
    }

    public static void levelOrderTraversal(Node head) {
        Queue<Node> tempQueue = new LinkedList<>();
        tempQueue.add(head);
        tempQueue.add(null);
        while (!tempQueue.isEmpty()) {
            Node currentNode = tempQueue.remove();
            if (currentNode == null) {
                if (tempQueue.isEmpty()) {
                    break;
                } else {
                    System.out.println();
                    tempQueue.add(null);
                }
            } else {
                System.out.print(currentNode.data + " ");
                if (currentNode.leftPointer != null) {
                    tempQueue.add(currentNode.leftPointer);
                }
                if (currentNode.rightPointer != null) {
                    tempQueue.add(currentNode.rightPointer);
                }
            }

        }
    }

    public static int findHeightOfTree(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + Math.max(findHeightOfTree(head.leftPointer), findHeightOfTree(head.rightPointer));
    }

    public static int countTotalNumberOfNode(Node head) {
        if (head == null) {
            return 0;
        }
        return 1 + countTotalNumberOfNode(head.leftPointer) + countTotalNumberOfNode(head.rightPointer);
    }

    public static int sumOfNode(Node head) {
        if (head == null) {
            return 0;
        }
        return head.data + sumOfNode(head.leftPointer) + sumOfNode(head.rightPointer);
    }

    public static int findDiameter(Node head) {
        if (head == null) {
            return 0;
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, 6, -1, 7, -1, -1, 3, -1, -1 };
        Node head = createTree(arr);
        preOrderTraversal(head);
        System.out.println("====>");
        inOrderTraversal(head);
        System.out.println("------->");
        postOrderTraversal(head);
        System.out.println("--======>");
        levelOrderTraversal(head);
        System.out.println();
        System.out.println("Height-->");
        System.out.println(findHeightOfTree(head));
        System.out.println();
        System.out.println("total Number of count");
        System.out.println(countTotalNumberOfNode(head));
        System.out.println();
        System.out.println("find sum of Node");
        System.out.println(sumOfNode(head));

    }

}
