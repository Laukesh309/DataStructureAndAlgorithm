package TreeStriver;

import java.util.LinkedList;
import java.util.Queue;

import java.util.ArrayList;

public class zigzagtraversal {
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

    public static void printZigZag(Node root) {
        Queue<Node> que = new LinkedList<>();
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        que.add(root);
        int flag = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            ArrayList<Integer> result = new ArrayList<>(size);
            for (int i = 0; i < size; i++) {
                result.add(0); // or any other default value
            }
            for (int i = 0; i < size; i++) {
                Node curNode = que.remove();
                // System.out.println(curNode.data);
                if (curNode.left != null) {
                    que.add(curNode.left);
                }
                if (curNode.right != null) {
                    que.add(curNode.right);
                }
                if (flag == 0) {
                    result.set(i, curNode.data);
                } else {
                    result.set(size - i - 1, curNode.data);

                }
            }
            finalResult.add(result);
            if (flag == 0) {
                flag = 1;
            } else {
                flag = 0;
            }

        }
        System.out.println(finalResult);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        Node root = createTree(arr);
        printZigZag(root);

    }

}
