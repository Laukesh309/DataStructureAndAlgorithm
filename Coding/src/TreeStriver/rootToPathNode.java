package TreeStriver;

import java.util.ArrayList;

public class rootToPathNode {
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

    public static void findNode(ArrayList<ArrayList<Integer>> finalResult, Node root, ArrayList<Integer> tempResult) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ArrayList<Integer> temp = new ArrayList<>(tempResult);
            temp.add(root.data);
            finalResult.add(temp);
            return;

        }
        tempResult.add(root.data);
        findNode(finalResult, root.left, tempResult);
        findNode(finalResult, root.right, tempResult);
        tempResult.remove(tempResult.size() - 1);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, -1 };
        Node root = createTree(arr);
        ArrayList<ArrayList<Integer>> finalResult = new ArrayList<>();
        findNode(finalResult, root, new ArrayList<>());
        System.out.println(finalResult);
    }

}
