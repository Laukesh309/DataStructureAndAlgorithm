package GFGTREE.Medium;

import java.util.Arrays;
import java.util.HashMap;

public class constructBSTPreOrder {

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

    public static Node constructTree(int startIndex, int endIndex, int preOrder[], int inOrder[], int currentIndex[],
            HashMap<Integer, Integer> hm) {
        if (startIndex > endIndex) {
            return null;
        }
        currentIndex[0]++;
        int currentValue = preOrder[currentIndex[0]];
        Node newNode = new Node(currentValue);
        int inOrderIndex = hm.get(currentValue);
        newNode.left = constructTree(startIndex, inOrderIndex - 1, preOrder, inOrder, currentIndex, hm);
        newNode.right = constructTree(inOrderIndex + 1, endIndex, preOrder, inOrder, currentIndex, hm);
        return newNode;

    }

    public static void main(String[] args) {
        int pre[] = { 40, 30, 35, 80, 100 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        int inOrder[] = new int[pre.length];
        for (int i = 0; i < pre.length; i++) {
            inOrder[i] = pre[i];
            hm.put(pre[i], i);
        }
        Arrays.sort(inOrder);
        int currentIndex[] = { -1 };
        Node rootNode = constructTree(0, pre.length - 1, pre, inOrder, currentIndex, hm);
        System.out.println(rootNode.data);
    }

}
