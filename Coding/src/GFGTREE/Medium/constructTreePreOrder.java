package GFGTREE.Medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class constructTreePreOrder {

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

    public static void printLevelOrderTraversal(Node root) {
        Queue<Node> que = new LinkedList<>();
        que.add(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                Node currentNode = que.poll();
                System.out.print(currentNode.data + " ");
                if (currentNode.left != null) {
                    que.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    que.add(currentNode.right);
                }
            }
            System.out.println();

        }
    }

    public Node constructTree(int startIndex, int endIndex, int preOrder[], int inOrder[],
            HashMap<Integer, Integer> hm) {
        System.out.println("index" + startIndex + endIndex);
        if (startIndex > endIndex) {
            return null;
        }
        currentIndex++;
        System.out.println("currentIndex" + currentIndex);
        int currentValue = preOrder[currentIndex];
        Node newNode = new Node(currentValue);
        newNode.left = constructTree(startIndex, hm.get(currentValue) - 1, preOrder, inOrder, hm);
        newNode.right = constructTree(hm.get(currentValue) + 1, endIndex, preOrder, inOrder, hm);
        return newNode;
    }

    public static void main(String[] args) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        int inorder[] = { 3, 1, 4, 0, 5, 2 };
        int preorder[] = { 0, 1, 3, 4, 2, 5 };
        for (int i = 0; i < inorder.length; i++) {
            hm.put(inorder[i], i);
        }
        constructTreePreOrder cto = new constructTreePreOrder();
        Node root = cto.constructTree(0, preorder.length - 1, preorder, inorder, hm);
        printLevelOrderTraversal(root);
    }

}
